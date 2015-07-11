package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.generate.User;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;

public interface IManufacturinOrder {
	public OrderManufacturing findById(long id);
	public OrderManufacturing findByRef(String ref);
	public List<OrderManufacturing> getAllOF(int start, int length, String sorting, String filter);
	public List<OrderManufacturing> getTerminateOF();
	public long createOF(OrderManufacturing OF);
	public void updateOF(OrderManufacturing OF);
	public void deleteOF(OrderManufacturing OF);
	public long ManufacturingCount(String filter);
	public List<User> searchResponsable(int lenght, int start, String search);
	public List<Warehouse> searchCenter(int lenght, int start, String search);
}
