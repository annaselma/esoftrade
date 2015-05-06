package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import ma.esoftech.esoftrade.DTO.MouvementDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.Dao.IMouvementDao;
import ma.esoftech.esoftrade.model.Mouvement;
import ma.esoftech.esoftrade.model.Mouvement.MouvementType;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;
import ma.esoftech.esoftrade.service.IMouvementService;
import ma.esoftech.esoftrade.service.ServiceUtils;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class MouvementServiceImpl implements IMouvementService {
	@Autowired
	Mapper mapper;
	@Autowired
	IMouvementDao mouvementdao;
	
	@Override
	public MouvementDTO FindByID(long id) {
		Mouvement mouvement= mouvementdao.FindByID(id);
		if(mouvement==null){
			System.out.println("error ");
		}
	MouvementDTO mouvementDTO= mapper.map(mouvement, MouvementDTO.class);
		return mouvementDTO;
	}

	@Override
	public long createMouvement(MouvementDTO mouvement,UserDTO creator) {
		
		Mouvement mouvEntity= mapper.map(mouvement, Mouvement.class);
		ServiceUtils.buildEntityModel(creator, mouvEntity);
		return  mouvementdao.createMouvement(mouvEntity);
	}

	@Override
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
	public long MouvementCount(String filter) {
		// TODO Auto-generated method stub
		return mouvementdao.MouvementCount(filter);
	}

	@Override
	public List<MouvementDTO> getListMouvementByWarehouse(int start,
			int length, String sorting, String filter, WarehouseDTO warehouse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long MouvementCountByWarehouse(String filter, WarehouseDTO warehouse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
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
	public void transfertStock(WarehouseDTO source, WarehouseDTO target,
			ProductDTO product, int nbre,String notes,UserDTO creator) {
		int negatifNumber=nbre*-1;//
		Mouvement mouvementSource=buildMouvement(source,product,negatifNumber,notes,creator);
		mouvementSource.setType(MouvementType.transfertStock);
		Mouvement mouvementTarget= buildMouvement(target, product, nbre, notes, creator);
		mouvementTarget.setType(MouvementType.transfertStock);
		mouvementdao.createMouvement(mouvementSource);
		
		
	}

}
