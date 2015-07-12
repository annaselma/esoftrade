package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import ma.esoftech.esoftrade.DTO.MouvementDTO;
import ma.esoftech.esoftrade.DTO.OrderDTO;
import ma.esoftech.esoftrade.DTO.OrderExpedition;
import ma.esoftech.esoftrade.DTO.OrderExpeditionList;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.ProductWarehouseDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.Dao.IMouvementDao;
import ma.esoftech.esoftrade.Dao.IProductDao;
import ma.esoftech.esoftrade.model.Mouvement;
import ma.esoftech.esoftrade.model.Mouvement.MouvementType;
import ma.esoftech.esoftrade.model.OrderDocument;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductWarehouse;
import ma.esoftech.esoftrade.model.Warehouse;
import ma.esoftech.esoftrade.service.IMouvementService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class MouvementServiceImpl implements IMouvementService {
	@Autowired
	Mapper mapper;
	@Autowired
	IMouvementDao mouvementdao;
	@Autowired
	IProductDao productDao;
	
	@Override
	@Transactional(readOnly=true)
	public MouvementDTO FindByID(long id) {
		Mouvement mouvement= mouvementdao.FindByID(id);
		if(mouvement==null){
			System.out.println("error ");
		}
	MouvementDTO mouvementDTO= mapper.map(mouvement, MouvementDTO.class);
		return mouvementDTO;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createMouvement(MouvementDTO mouvement,UserDTO creator) {
		
		Mouvement mouvEntity= mapper.map(mouvement, Mouvement.class);
		ServiceUtils.buildEntityModel(creator, mouvEntity);
		return  mouvementdao.createMouvement(mouvEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public List<MouvementDTO> getListMouvement(int start, int length,
			String sorting, String filter) {
		List<Mouvement> mouvementEntity= mouvementdao.getListMouvement(start, length, sorting, filter);
		List<MouvementDTO>mouvementDTOs= new ArrayList<MouvementDTO>();
		for (Mouvement mouv : mouvementEntity) {
			mouvementDTOs.add(mapper.map(mouv, MouvementDTO.class));
		}
		return mouvementDTOs;
	}

	@Override
	@Transactional(readOnly=true)
	public long MouvementCount(String filter) {
		return mouvementdao.MouvementCount(filter);
	}
	@Override
	@Transactional(readOnly=true)
	public List<MouvementDTO> getListMouvementByOrder(int start, int length,
			String sorting, String filter,OrderDTO order) {
		OrderDocument o=new OrderDocument();
		o.setId(order.getId());
		List<Mouvement> mouvementEntity= mouvementdao.getListMouvementByOrder(start, length, sorting, filter, o);
		List<MouvementDTO>mouvementDTOs= new ArrayList<MouvementDTO>();
		for (Mouvement mouv : mouvementEntity) {
			mouvementDTOs.add(mapper.map(mouv, MouvementDTO.class));
		}
		return mouvementDTOs;
	}

	@Override
	@Transactional(readOnly=true)
	public long MouvementCountByOrder(String filter,OrderDTO order) {
		OrderDocument o=new OrderDocument();
		o.setId(order.getId());
		return mouvementdao.MouvementCountByOrder(filter, o);
	}

	@Override
	@Transactional(readOnly=true)
	public List<MouvementDTO> getListMouvementByWarehouse(int start,
			int length, String sorting, String filter, WarehouseDTO warehouse) {
		Warehouse warehouseEntity= new Warehouse();
		warehouseEntity.setId(warehouse.getId());
		
		List<Mouvement> listEntiy=mouvementdao.getListMouvementByWarehouse(start, length, sorting, filter, warehouseEntity);

		return DozerHelper.map(mapper, listEntiy,MouvementDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public long MouvementCountByWarehouse(String filter, WarehouseDTO warehouse) {
		Warehouse warehouseEntity= new Warehouse();
		warehouseEntity.setId(warehouse.getId());
		return mouvementdao.MouvementCountByWarehouse(filter, warehouseEntity);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void correctStock(WarehouseDTO warehouse, ProductDTO product,
			int nbre,String notes,UserDTO creator) {
	Mouvement mouvement= buildMouvement(warehouse,product,nbre,notes,creator);
	mouvement.setType(MouvementType.stockCorrection);
	mouvementdao.createMouvement(mouvement);
	}
	private Mouvement buildMouvement(WarehouseDTO warehouse, ProductDTO product,
			int nbre,String notes,UserDTO creator){
		Mouvement mouvement= new Mouvement();
		ServiceUtils.buildEntityModel(creator, mouvement);
		mouvement.setQuantity(nbre);
		mouvement.setMotif(notes);
		Warehouse warehouseEntity=new Warehouse();
		warehouseEntity.setId(warehouse.getId());
		Product productEntity =new Product();
		productEntity.setId(product.getId());
		mouvement.setProduct(productEntity);
		mouvement.setWarehouse(warehouseEntity);
		return mouvement;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void transfertStock(WarehouseDTO source, WarehouseDTO target,
			ProductDTO product, int nbre,String notes,UserDTO creator) {
		int negatifNumber=nbre*-1;//
		Mouvement mouvementSource=buildMouvement(source,product,negatifNumber,notes,creator);
		mouvementSource.setType(MouvementType.transfertStock);
		Mouvement mouvementTarget= buildMouvement(target, product, nbre, notes, creator);
		mouvementTarget.setType(MouvementType.transfertStock);
		mouvementdao.createMouvement(mouvementSource);
		mouvementdao.createMouvement(mouvementTarget);
		
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void transfertStockfromOF(WarehouseDTO source, WarehouseDTO target,
			ProductDTO product, int nbre,String notes,UserDTO creator,OrderManufacturingDTO manufacturing) {
		int negatifNumber=nbre*-1;//
		 OrderManufacturing oF=new OrderManufacturing();
		 oF.setId(manufacturing.getId());
		Mouvement mouvementSource=buildMouvement(source,product,negatifNumber,notes,creator);
		mouvementSource.setOfabrication(oF);
		mouvementSource.setType(MouvementType.manufacturing);
		Mouvement mouvementTarget= buildMouvement(target, product, nbre, notes, creator);
		mouvementTarget.setType(MouvementType.manufacturing);
		mouvementTarget.setOfabrication(oF);
		mouvementdao.createMouvement(mouvementSource);
		mouvementdao.createMouvement(mouvementTarget);
		
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void delivryStockfromOrder(OrderExpeditionList expedition,UserDTO creator) {
		Product pr=new Product();
		WarehouseDTO warehouse=new WarehouseDTO();
		ProductDTO product=new ProductDTO();
		OrderDocument order=new OrderDocument();
		order.setId(expedition.getOrder().getId());
		Mouvement mouvement=null;
		for(OrderExpedition exp : expedition.getExpeditions()){
            pr.setId(exp.getProduct().getId());
			warehouse.setId(exp.getWarehouse().getId());
			product.setId(pr.getId());
			mouvement=buildMouvement(warehouse, product, (int)-exp.getQte(),"CAUSE Customer ORDER", creator);
			mouvement.setOrderDocument(order);
			mouvement.setType(MouvementType.customerOrder);
			mouvementdao.createMouvement(mouvement);	
		}
		
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void importStockfromOrder(OrderExpeditionList expedition,UserDTO creator) {
		Product pr=new Product();
		WarehouseDTO warehouse=new WarehouseDTO();
		ProductDTO product=new ProductDTO();
		OrderDocument order=new OrderDocument();
		order.setId(expedition.getOrder().getId());
		Mouvement mouvement=null;
		for(OrderExpedition exp : expedition.getExpeditions()){
			pr=productDao.findById(exp.getProduct().getId());
			long qteStock=productDao.getProductQuantity(pr);
			calculPMP(qteStock,pr,exp.getQte(),exp.getPrice());
			productDao.updateProduct(pr);
			warehouse.setId(exp.getWarehouse().getId());
			product.setId(pr.getId());
			mouvement=buildMouvement(warehouse, product, (int)exp.getQte(),"CAUSE SUPPLIER ORDER", creator);
			mouvement.setOrderDocument(order);
			mouvement.setType(MouvementType.supplierOrder);
			mouvementdao.createMouvement(mouvement);	
		}
		
		
	}
	private void calculPMP(long stock,Product pr,long qte,float price){
		pr.setPmp((float)(stock*pr.getPmp()+qte*price)/(stock+qte));

	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductWarehouseDTO> getListProductByWarehouse(int start,
			int length, String sorting, String filter, WarehouseDTO warehouse) {
		Warehouse warehouseEntity= new Warehouse();
		warehouseEntity.setId(warehouse.getId());
		List<ProductWarehouse>listEntity=mouvementdao.ListProductByWarehouse(start, length, sorting, filter, warehouseEntity);
		List<ProductWarehouseDTO>listDTO= new ArrayList<ProductWarehouseDTO>();
		for (ProductWarehouse productWehouse : listEntity) {
			listDTO.add(mapper.map(productWehouse, ProductWarehouseDTO.class));
			
		}
		return listDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public long ProductCountByWarehouse(String filter, WarehouseDTO warehouse) {
		Warehouse warehouseEntity= new Warehouse();
		warehouseEntity.setId(warehouse.getId());
		return mouvementdao.ProductCountByWarehouse(filter, warehouseEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductWarehouseDTO> getListWarehouseByProduct(int start,
			int length, String sorting, String filter, ProductDTO product) {
		Product productEntity= new Product();
		productEntity.setId(product.getId());
		List<ProductWarehouse>listEntity=mouvementdao.getListWarehouseByProduct(start, length, sorting, filter, productEntity);
		List<ProductWarehouseDTO>listDTO= new ArrayList<ProductWarehouseDTO>();
		for (ProductWarehouse productWehouse : listEntity) {
			System.out.println("ge"+productWehouse.getQuantity());
			listDTO.add(mapper.map(productWehouse, ProductWarehouseDTO.class));
			
		}
		return listDTO;
	}

	@Override
	@Transactional(readOnly=true)
	public long ProductCountByProduct(String filter, ProductDTO product) {
		Product productEntity=new Product();
		productEntity.setId(product.getId());
		return mouvementdao.WarehouseCountByProduct(filter, productEntity);
	}

}
