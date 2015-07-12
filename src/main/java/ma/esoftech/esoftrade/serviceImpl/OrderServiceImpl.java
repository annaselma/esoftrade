package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.OrderDTO;
import ma.esoftech.esoftrade.DTO.OrderLineDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.Dao.IOrderDao;
import ma.esoftech.esoftrade.exception.CompanyNotFoundException;
import ma.esoftech.esoftrade.exception.OrderNotFoundException;
import ma.esoftech.esoftrade.exception.OrderUpdateException;
import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.OrderDocument;
import ma.esoftech.esoftrade.model.OrderDocument.OrderStatus;
import ma.esoftech.esoftrade.model.OrderDocument.OrderType;
import ma.esoftech.esoftrade.model.OrderLine;
import ma.esoftech.esoftrade.service.IOrderService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	Mapper mapper;
	@Autowired
	IOrderDao orderDao;
	@Autowired
	IFileDao fileDao;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createOrder(OrderDTO order, UserDTO creator) {
		OrderDocument orderEntity= mapper.map(order, OrderDocument.class);
		ServiceUtils.buildEntityModel(creator, orderEntity);
		orderEntity.setReference(ServiceUtils.TMP_REF);
		orderEntity.setCustomerReference(ServiceUtils.TMP_REF);
		orderEntity.setSupplierReference(ServiceUtils.TMP_REF);
		orderEntity.setStatus(OrderStatus.draft);
		Long idReturn=orderDao.createOrder(orderEntity);
		orderEntity.setId(idReturn);
		orderEntity.generateReference();
		orderDao.updateOrder(orderEntity);
		return idReturn;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateOrder(OrderDTO order, UserDTO modifier)
			throws OrderNotFoundException, OrderUpdateException {
		OrderDocument orderEntity= mapper.map(order, OrderDocument.class);
		OrderDocument ordertmp=orderDao.findById(orderEntity.getId());
		    
			   if(ordertmp==null){
				   throw new  OrderNotFoundException(order.getId());
			   }
			    orderEntity.setReference( ordertmp.getReference());
			    orderEntity.setType(ordertmp.getType());
			    orderEntity.setCustomerReference(ordertmp.getCustomerReference());
			    orderEntity.setSupplierReference( ordertmp.getSupplierReference());
			    orderEntity.setCreator( ordertmp.getCreator());
			    orderEntity.setCreateDate( ordertmp.getCreateDate());
			    ServiceUtils.EditEntityModel(modifier, orderEntity);
			    orderEntity.setDeleted(false);
			    orderEntity.setLastEdit(new Date());
			    orderEntity.setFiles( ordertmp.getFiles());
			    orderEntity.setLines(ordertmp.getLines());
			    orderEntity.setTaxAmount(ordertmp.getTaxAmount());
			    orderEntity.setTotalAmount(ordertmp.getTotalAmount());
			    orderEntity.setNetAmount(ordertmp.getNetAmount());
			    orderDao.updateOrder(orderEntity);		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteOrder(OrderDTO order) throws OrderNotFoundException {
		OrderDocument orderDocument =new OrderDocument();
		orderDocument.setId(order.getId());
		orderDao.deleteOrder(orderDocument);
	}

	@Override
	@Transactional(readOnly=true)
	public OrderDTO findById(long id) throws OrderNotFoundException {
		OrderDocument order=orderDao.findById(id);
		if(order==null){
			throw new OrderNotFoundException(id);
		}
		return mapper.map(order, OrderDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderDTO> getCustomerOrders(int start, int length,
			String sorting, String filter) {
		List<OrderDocument> orders=orderDao.getOrders(start, length, sorting, OrderType.customerOrder, filter);
		return DozerHelper.map(mapper, orders,OrderDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderDTO> getSupplierOrders(int start, int length,
			String sorting, String filter) {
		List<OrderDocument> orders=orderDao.getOrders(start, length, sorting, OrderType.supplierOrder, filter);
		return DozerHelper.map(mapper, orders,OrderDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public long customerOrdersCount(String filter) {
		
		return orderDao.countOrders(OrderType.customerOrder, filter);
	}

	@Override
	@Transactional(readOnly=true)
	public long supplierOrdersCount(String filter) {
		return orderDao.countOrders(OrderType.supplierOrder, filter);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderDTO> searchCustomerOrders(int lenght, int start,
			String search) {
		List<OrderDocument> orders=orderDao.searchOrders(lenght, start, search, OrderType.customerOrder);
		return DozerHelper.map(mapper, orders,OrderDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderDTO> searchSupplierOrders(int lenght, int start,
			String search) {
		List<OrderDocument> orders=orderDao.searchOrders(lenght, start, search, OrderType.supplierOrder);
		return DozerHelper.map(mapper, orders,OrderDTO.class);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void attachFileToOrder(FileDTO fileDTO, long id, UserDTO modifier)
			throws OrderNotFoundException {
		OrderDocument orderEntity=orderDao.findById(id);
	    if(orderEntity==null){
	   	 throw new OrderNotFoundException(id);
	    }
	    ServiceUtils.EditEntityModel(modifier, orderEntity);
	    File file=new File();
	    file.setId(fileDTO.getId());
	    orderEntity.getFiles().add(file);
	    orderDao.updateOrder(orderEntity);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void dettachFileFromOrder(FileDTO fileDTO, long id, UserDTO modifier)
			throws OrderNotFoundException {
		OrderDocument orderEntity=orderDao.findById(id);
	    if(orderEntity==null){
	   	 throw new OrderNotFoundException(id);
	    }
	    ServiceUtils.EditEntityModel(modifier, orderEntity);
	    Set<File> files=orderEntity.getFiles();
	    Iterator<File> it=files.iterator();
	    File entity;
	    while(it.hasNext()){
	    	entity=it.next();
	    	if(entity.getId()==fileDTO.getId()){
	    		files.remove(entity);
	    		break;
	    	}
	    }
	    orderDao.updateOrder(orderEntity);
		
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void addRowToOrder(OrderLineDTO orderLine, OrderDTO order,
			UserDTO modifier) throws OrderNotFoundException {
		OrderLine orderLineEntity=mapper.map(orderLine,OrderLine.class);
		OrderDocument orderEntity=orderDao.findById(order.getId());
		if(orderEntity==null){
			throw new OrderNotFoundException(order.getId());
		}
		long idOrder=orderDao.createOrderLine(orderLineEntity);
		orderLineEntity.setId(idOrder);
		orderEntity.getLines().add(orderLineEntity);
		orderEntity.setTotalAmount(increaseTotalAmount(orderEntity.getTotalAmount(),
				orderLineEntity.getUnitPrice(),orderLineEntity.getTaxRate(),orderLineEntity.getReductionRate(),orderLineEntity.getQuantity()));
		orderEntity.setNetAmount(increaseNetAmount(orderEntity.getNetAmount(),orderLineEntity.getUnitPrice(),orderLineEntity.getQuantity()));
		  ServiceUtils.EditEntityModel(modifier, orderEntity);
		    orderEntity.setDeleted(false);
		    orderEntity.setLastEdit(new Date());
		    orderDao.updateOrder(orderEntity);
	
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateRow(OrderLineDTO orderLine, UserDTO modifier)
			throws OrderNotFoundException {
		OrderLine orderLineEntity=mapper.map(orderLine, OrderLine.class);
		orderDao.updateOrderLine(orderLineEntity);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteRowFromOrder(OrderLineDTO orderLine, OrderDTO order,
			UserDTO modifier) throws OrderNotFoundException {
		OrderDocument orderEntity=orderDao.findById(order.getId());
		if(orderEntity==null){
			throw new OrderNotFoundException(order.getId());
		}
		  ServiceUtils.EditEntityModel(modifier, orderEntity);
		    orderEntity.setDeleted(false);
		    orderEntity.setLastEdit(new Date());
		    Iterator<OrderLine> it=orderEntity.getLines().iterator();
		    OrderLine orderLineTest=null;
		    while(it.hasNext()){
		    	orderLineTest=it.next();
		    	if(orderLineTest.getId()==orderLine.getId()){
		    		orderEntity.setTotalAmount( reduceTotalAmount(orderEntity.getTotalAmount(),
		    				orderLineTest.getUnitPrice(),orderLineTest.getTaxRate(),orderLineTest.getReductionRate(),orderLineTest.getQuantity()));
		    		orderEntity.setNetAmount(reduceNetAmount(orderEntity.getNetAmount(),orderLineTest.getUnitPrice(),orderLineTest.getQuantity()));
		    		orderEntity.getLines().remove(orderLineTest);
		    	   break;
		    	}
		    }
		    orderDao.updateOrder(orderEntity);
		
	}
	private double reduceTotalAmount(double totalAmount,double unitPrice,double tax,double reduc,long qte){
		return totalAmount-qte*(unitPrice +(unitPrice*tax/100)-(unitPrice*reduc/100));
	}
	private double reduceNetAmount(double netAmount,double unitPrice,long qte){
		return netAmount-qte*unitPrice;
	}
	private double increaseTotalAmount(double totalAmount,double unitPrice,double tax,double reduc,long qte){
		return totalAmount+qte*(unitPrice +(unitPrice*tax/100)-(unitPrice*reduc/100));
	}
	private double increaseNetAmount(double netAmount,double unitPrice,long qte){
		return netAmount+qte*unitPrice;
	}

}
