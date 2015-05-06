package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.Dao.IWarehouseDao;
import ma.esoftech.esoftrade.exeption.WarehouseNotFoundException;
import ma.esoftech.esoftrade.model.Warehouse;
import ma.esoftech.esoftrade.service.IWarehouseService;
import ma.esoftech.esoftrade.service.ServiceUtils;
@Service
public class WarehouseServiceImpl implements IWarehouseService{
@Autowired
Mapper mapper;
@Autowired
IWarehouseDao warehouseDao;

	@Override
	@Transactional(readOnly=true)
	public WarehouseDTO findById(long id) throws WarehouseNotFoundException {
		Warehouse warehouse= warehouseDao.findById(id);
		if(warehouse==null){
			throw new WarehouseNotFoundException(id);
		}
		WarehouseDTO warehouseDto= mapper.map(warehouse, WarehouseDTO.class);
		return warehouseDto;
	}

	@Override
	@Transactional(readOnly=true)
	public WarehouseDTO findByname(String name) throws WarehouseNotFoundException {
		Warehouse warehouse= warehouseDao.findByname(name);
		if(warehouse==null){
			throw new WarehouseNotFoundException(name);
		}
		WarehouseDTO warehouseDto= mapper.map(warehouse, WarehouseDTO.class);
		return warehouseDto;
	}

	@Override
	@Transactional(readOnly=true)
	public List<WarehouseDTO> getListWarehouse(int start, int length,
			String sorting, String filter) {
		List<Warehouse>WrehouseEntitylist= warehouseDao.getListWarehouse(start, length, sorting, filter);
		List<WarehouseDTO>ListWarehouseDTO= new ArrayList<WarehouseDTO>();
		for (Warehouse warehouse : WrehouseEntitylist) {
			ListWarehouseDTO.add(mapper.map(warehouse, WarehouseDTO.class));
		}
		return ListWarehouseDTO;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createWarehouse(WarehouseDTO warehouse, UserDTO creator) {
		Warehouse warehouseEntity= mapper.map(warehouse, Warehouse.class);
		ServiceUtils.buildEntityModel(creator, warehouseEntity);
	 long idWarehouse=warehouseDao.createWarehouse(warehouseEntity);
	 warehouseEntity.setId(idWarehouse);
	 warehouseDao.updateWarehouse(warehouseEntity);
		return idWarehouse;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateWarehouse(WarehouseDTO warehouse, UserDTO modifier) throws WarehouseNotFoundException {
		Warehouse warehouseEntity= mapper.map(warehouse, Warehouse.class);
	    Warehouse warehousetmp= warehouseDao.findById(warehouseEntity.getId());
	    
	   if(warehousetmp==null){
		   throw new WarehouseNotFoundException();
	   }
	    warehouseEntity.setCreator(warehousetmp.getCreator());
	    warehouseEntity.setCreator(warehousetmp.getCreator());
	    ServiceUtils.EditEntityModel(modifier, warehouseEntity);
	    warehouseEntity.setDeleted(false);
	    warehouseEntity.setLastEdit(new Date());
		warehouseDao.updateWarehouse(warehouseEntity);
		
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteWarehouse(WarehouseDTO warehouse) {
		Warehouse warehouseEntity= mapper.map(warehouse, Warehouse.class);	
		warehouseEntity= new Warehouse();
		warehouseEntity.setId(warehouse.getId());
		warehouseDao.deleteWarehouse(warehouseEntity);
		
	}

	@Override
	@Transactional(readOnly=true)
	public long warehouseCount(String filter) {
		return warehouseDao.warehouseCount(filter);
	}
	//TO DO list Product

}
