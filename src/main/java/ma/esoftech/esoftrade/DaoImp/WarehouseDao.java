package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import ma.esoftech.esoftrade.Dao.IWarehouseDao;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;

public class WarehouseDao implements IWarehouseDao{

	@Override
	public Warehouse findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Warehouse findByname(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Warehouse> getListWarehouse(int start, int length,
			String sorting, String filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long warehouseCount(String filter) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product> getListProductByWarehouse(int lenght, int start,
			String sorting, String filter, Warehouse category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long productCountBywrehouse(String filter, Warehouse warehouse) {
		// TODO Auto-generated method stub
		return 0;
	}

}
