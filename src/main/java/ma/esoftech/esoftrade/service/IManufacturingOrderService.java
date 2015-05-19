package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;

public interface IManufacturingOrderService {
	public OrderManufacturingDTO findOFById(Long id) throws ManufacturingNotFoundException;
	public OrderManufacturingDTO findOFByRef(String ref) throws ManufacturingNotFoundException;
	public List<OrderManufacturingDTO> getAllOF(int start, int length,String sorting, String filter);
	public long createOF(OrderManufacturingDTO OrderFacturing, UserDTO creator);
	public void updateOF(OrderManufacturingDTO OrderFacturing, UserDTO modifier) throws ManufacturingNotFoundException;
	public void deleteOF(OrderManufacturingDTO OrderFacturing);
	public long OrderFacturingCount(String filter);}
