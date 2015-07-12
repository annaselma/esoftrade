package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.model.Mouvement;
import ma.esoftech.esoftrade.model.OrderDocument;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductWarehouse;
import ma.esoftech.esoftrade.model.Warehouse;

public interface IMouvementDao {
public Mouvement FindByID(long id);
public long createMouvement(Mouvement mouvement);
public List<Mouvement>getListMouvement(int start, int length, String sorting, String filter);
public long MouvementCount(String filter);
public List<Mouvement>getListMouvementByWarehouse(int start, int length, String sorting, String filter,Warehouse warehouse);
public long MouvementCountByWarehouse(String filter,Warehouse warehouse);
public List<ProductWarehouse>ListProductByWarehouse(int start, int length, String sorting, String filter,Warehouse warehouse);
public long ProductCountByWarehouse(String filter, Warehouse warehouse);
public List<ProductWarehouse>getListWarehouseByProduct(int start, int length, String sorting, String filter,Product product);
public long WarehouseCountByProduct(String filter,Product product);
List<Mouvement> getListMouvementByOrder(int start, int length, String sorting,
		String filter, OrderDocument order);
long MouvementCountByOrder(String filter, OrderDocument order);
}
