package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.exception.WarehouseNotFoundException;
import ma.esoftech.esoftrade.model.ProductCategory;

public interface IWarehouseService {
	public WarehouseDTO findById(long id) throws WarehouseNotFoundException;
	public WarehouseDTO findByname(String name) throws WarehouseNotFoundException;
	public List<WarehouseDTO>getListWarehouse(int start, int length, String sorting, String filter);
	public List<WarehouseDTO>getListWarehouse(int start, int length);
    public long createWarehouse(WarehouseDTO warehouse, UserDTO creator);
    public void updateWarehouse(WarehouseDTO warehouse, UserDTO modifier) throws WarehouseNotFoundException;
    public void deleteWarehouse(WarehouseDTO warehouse);
    public long warehouseCount(String filter);
}
