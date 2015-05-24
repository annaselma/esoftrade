package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;

public interface IManufacturingOrderService {
	public OrderManufacturingDTO findOFById(Long id) throws ManufacturingNotFoundException;
	public OrderManufacturingDTO findOFByRef(String ref) throws ManufacturingNotFoundException;
	public List<OrderManufacturingDTO> getAllOF(int start, int length,String sorting, String filter);
	public long createOF(OrderManufacturingDTO OrderFacturing, UserDTO creator);
	public void updateOF(OrderManufacturingDTO OrderFacturing, UserDTO modifier) throws ManufacturingNotFoundException;
	public void deleteOF(OrderManufacturingDTO OrderFacturing);
	public long OrderFacturingCount(String filter);
	public void updatePicture(FileDTO picture,long id,UserDTO modifier) throws ManufacturingNotFoundException ;	
	public void attachFileToManufacturing(FileDTO fileDTO,long id,UserDTO modifier) throws ManufacturingNotFoundException;	
	public List<UserDTO> searchResponsable(int lenght, int start, String search);
	public List<WarehouseDTO> searchWarehouse(int lenght, int start, String search);

}
