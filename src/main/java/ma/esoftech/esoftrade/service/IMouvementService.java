package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.MouvementDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.ProductWarehouseDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.model.ProductWarehouse;

public interface IMouvementService {
	public MouvementDTO FindByID(long id);
	public long createMouvement(MouvementDTO mouvement,UserDTO creator);
	public List<MouvementDTO>getListMouvement(int start, int length, String sorting, String filter);
	public long MouvementCount(String filter);
	public List<MouvementDTO>getListMouvementByWarehouse(int start, int length, String sorting, String filter,WarehouseDTO warehouse);
	public long MouvementCountByWarehouse(String filter,WarehouseDTO warehouse);
	public void correctStock(WarehouseDTO warehouse, ProductDTO product,int nbre,String notes,UserDTO creator);
	public void transfertStock(WarehouseDTO source,WarehouseDTO target,ProductDTO product, int nbre,String notes,UserDTO creator);
    public List<ProductWarehouseDTO> getListProductByWarehouse(int start, int length, String sorting, String filter,WarehouseDTO warehouse);
    public long ProductCountByWarehouse(String filter,WarehouseDTO warehouse);
}
