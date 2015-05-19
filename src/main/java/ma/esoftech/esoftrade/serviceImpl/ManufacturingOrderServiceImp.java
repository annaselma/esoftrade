package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IManufacturinOrder;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;
@Service
public class ManufacturingOrderServiceImp implements IManufacturingOrderService{
@Autowired
Mapper mapper;
@Autowired
IManufacturinOrder manufacturingDao;

@Override
@Transactional(readOnly=true)
public OrderManufacturingDTO findOFById(Long id) throws ManufacturingNotFoundException {
	OrderManufacturing manufacturingOrder= manufacturingDao.findById(id);
	if(manufacturingOrder==null){
		throw new ManufacturingNotFoundException(id);
	}  OrderManufacturingDTO manufacturingOrderDTO= mapper.map(manufacturingOrder, OrderManufacturingDTO.class);
		return manufacturingOrderDTO;
}
@Override
@Transactional(readOnly=true)
public OrderManufacturingDTO findOFByRef(String ref) throws ManufacturingNotFoundException {
OrderManufacturing manufacturingOrder=manufacturingDao.findByRef(ref);
if(manufacturingOrder==null){
	throw new ManufacturingNotFoundException();
}  OrderManufacturingDTO manufacturingOrderDTO= mapper.map(manufacturingOrder, OrderManufacturingDTO.class);
	return manufacturingOrderDTO;
}
@Override
@Transactional(readOnly=true)
public List<OrderManufacturingDTO> getAllOF(int start, int length,
		String sorting, String filter) {
	List<OrderManufacturing>listEntity=manufacturingDao.getAllOF(start, length, sorting, filter);
	return DozerHelper.map(mapper, listEntity, OrderManufacturingDTO.class);
}
@Override
@Transactional(rollbackFor=Exception.class)
public long createOF(OrderManufacturingDTO OrderFacturing, UserDTO creator) {
OrderManufacturing OFEntity=mapper.map(OrderFacturing, OrderManufacturing.class);
	ServiceUtils.buildEntityModel(creator,OFEntity);
	OFEntity.setRef(ServiceUtils.TMP_REF);
	Long idOF=manufacturingDao.createOF(OFEntity);
	OFEntity.setId(idOF);
     OFEntity.generateReference();
	manufacturingDao.updateOF(OFEntity);
	return idOF;
}
@Override
@Transactional(rollbackFor=Exception.class)
public void updateOF(OrderManufacturingDTO OrderFacturing, UserDTO modifier) throws ManufacturingNotFoundException {
	OrderManufacturing OFEntity=mapper.map(OrderFacturing, OrderManufacturing.class);
    OrderManufacturing OFTmp= manufacturingDao.findById(OFEntity.getId());
    
   if( OFTmp==null){
	   throw new ManufacturingNotFoundException();
   }
   OFEntity.setRef(OFTmp.getRef());
   OFEntity.setCreator(OFTmp.getCreator());
   OFEntity.setCreateDate(OFTmp.getCreateDate());
    ServiceUtils.EditEntityModel(modifier,OFEntity);
    OFEntity.setDeleted(false);
    OFEntity.setLastEdit(new Date());
	manufacturingDao.updateOF(OFEntity);
}
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteOF(OrderManufacturingDTO OrderFacturing) {
	OrderManufacturing OFEntity=mapper.map(OrderFacturing, OrderManufacturing.class);
	OFEntity= new OrderManufacturing();
	OFEntity.setId(OrderFacturing.getId());
	manufacturingDao.deleteOF(OFEntity);
	
}
@Override
@Transactional(readOnly=true)
public long OrderFacturingCount(String filter) {
	
	return manufacturingDao.ManufacturingCount(filter);
}

	
}
