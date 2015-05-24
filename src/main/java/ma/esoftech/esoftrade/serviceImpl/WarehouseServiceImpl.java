package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.Dao.IWarehouseDao;
import ma.esoftech.esoftrade.exception.WarehouseNotFoundException;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.Warehouse;
import ma.esoftech.esoftrade.service.IWarehouseService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
		
		warehouseEntity.setRef(ServiceUtils.TMP_REF);
	 long idWarehouse=warehouseDao.createWarehouse(warehouseEntity);
	 warehouseEntity.setId(idWarehouse);
	 warehouseEntity.generateReference();
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
	    warehouseEntity.setCreateDate(warehousetmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, warehouseEntity);
	    warehouseEntity.setDeleted(false);
	    warehouseEntity.setLastEdit(new Date());
	    warehouseEntity.setRef(warehousetmp.getRef());
	    warehouseEntity.setFiles(warehousetmp.getFiles());
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

	@Override
	@Transactional(readOnly=true)
	public List<WarehouseDTO> getListWarehouse(int start, int length) {
		List<Warehouse>WrehouseEntitylist= warehouseDao.getListWarehouses(start, length);
		List<WarehouseDTO>ListWarehouseDTO= new ArrayList<WarehouseDTO>();
		for (Warehouse warehouse : WrehouseEntitylist) {
			ListWarehouseDTO.add(mapper.map(warehouse, WarehouseDTO.class));
		}
		return ListWarehouseDTO;
	}
	@Transactional(rollbackFor=Exception.class)
	public void attachFileToWarehouse(FileDTO fileDTO,long id,UserDTO modifier) throws WarehouseNotFoundException{
		Warehouse warehouseEntity=warehouseDao.findById(id);
	    if(warehouseEntity==null){
	   	 throw new WarehouseNotFoundException(id);
	    }
	    ServiceUtils.EditEntityModel(modifier, warehouseEntity);
	    File file=new File();
	    file.setId(fileDTO.getId());
	    warehouseEntity.getFiles().add(file);
	   warehouseDao.updateWarehouse(warehouseEntity);
	}
	@Override
	@Transactional(readOnly=true)
	public List<WarehouseDTO> searchWarehouses(int lenght, int start,
			String search) {
		List<Warehouse> listEntity=warehouseDao.searchWarehouses(lenght, start, search);
		return DozerHelper.map(mapper, listEntity,WarehouseDTO.class);
	}

}
