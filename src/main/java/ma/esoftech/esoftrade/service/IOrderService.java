package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.OrderDTO;
import ma.esoftech.esoftrade.DTO.OrderLineDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.OrderNotFoundException;
import ma.esoftech.esoftrade.exception.OrderUpdateException;

public interface IOrderService {
	public long createOrder(OrderDTO order, UserDTO creator);
	public void updateOrder(OrderDTO order, UserDTO modifier) throws OrderNotFoundException, OrderUpdateException;
	public void deleteOrder(OrderDTO order) throws OrderNotFoundException;
	public OrderDTO findById(long id) throws OrderNotFoundException;
	public List<OrderDTO> getCustomerOrders(int start, int length,String sorting, String filter);
	public List<OrderDTO> getSupplierOrders(int start, int length,String sorting, String filter);
	public long customerOrdersCount(String filter);
	public long supplierOrdersCount(String filter);
	public List<OrderDTO> searchCustomerOrders(int lenght, int start, String search);
	public List<OrderDTO> searchSupplierOrders(int lenght, int start, String search);
	public void attachFileToOrder(FileDTO fileDTO,long id,UserDTO modifier) throws OrderNotFoundException;
	public void dettachFileFromOrder(FileDTO fileDTO,long id,UserDTO modifier)throws OrderNotFoundException;
	public void addRowToOrder(OrderLineDTO orderLine,OrderDTO order, UserDTO modifier)throws OrderNotFoundException;
	public void updateRow(OrderLineDTO orderLine, UserDTO modifier)throws OrderNotFoundException; 
	public void deleteRowFromOrder(OrderLineDTO orderLine,OrderDTO order, UserDTO modifier)throws OrderNotFoundException;
	

}
