package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;

public interface IWarehouseDao {
	public Warehouse findById(long id);
	public Warehouse findByname(String name);
	public List<Warehouse>getListWarehouse(int start, int length, String sorting, String filter);
	public List<Warehouse>getListWarehouses(int start, int length);
    public long createWarehouse(Warehouse warehouse);
    public void updateWarehouse(Warehouse warehouse);
    public void deleteWarehouse(Warehouse warehouse);
    public long warehouseCount(String filter);
  public List<Product> getListProductByWarehouse(int lenght, int start, String sorting,String filter,Warehouse warehouse);
   public long productCountBywrehouse(String filter, Warehouse warehouse);
}
