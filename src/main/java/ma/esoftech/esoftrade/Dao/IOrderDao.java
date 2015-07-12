package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.OrderDocument;
import ma.esoftech.esoftrade.model.OrderDocument.OrderType;
import ma.esoftech.esoftrade.model.OrderLine;

public interface IOrderDao {

	public long createOrder(OrderDocument order);
	public void updateOrder(OrderDocument order);
	public void deleteOrder(OrderDocument order);
	public OrderDocument findById(long id);
	public List<OrderDocument> getOrders(int start, int length,String sorting,OrderType type,String filter);
	public long countOrders(OrderType type,String filter);
	public List<OrderDocument> searchOrders(int lenght, int start, String search,OrderType type);
	public long createOrderLine(OrderLine orderLine);
	public void updateOrderLine(OrderLine orderLine);
	
}
