package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.GammeDTO;
import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.Dao.IGammeDao;
import ma.esoftech.esoftrade.Dao.IManufacturinOrder;
import ma.esoftech.esoftrade.Dao.INomenclatureDao;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;
import ma.esoftech.esoftrade.generate.User;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.Gamme;
import ma.esoftech.esoftrade.model.Nomenclature;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;
@Service
public class ManufacturingOrderServiceImp implements IManufacturingOrderService{
@Autowired
Mapper mapper;
@Autowired
IManufacturinOrder manufacturingDao;
@Autowired
IFileDao fileDao;
@Autowired
INomenclatureDao nomenclatureDao;
@Autowired
IGammeDao gammeDao;

@Override
@Transactional(readOnly=true)
public OrderManufacturingDTO findOFById(Long id) throws ManufacturingNotFoundException {
	OrderManufacturing manufacturingOrder= manufacturingDao.findById(id);
	if(manufacturingOrder==null){
		throw new ManufacturingNotFoundException(id);
	}  OrderManufacturingDTO manufacturingOrderDTO= mapper.map(manufacturingOrder, OrderManufacturingDTO.class);
		return manufacturingOrderDTO;
}
@Override
@Transactional(readOnly=true)
public OrderManufacturingDTO findOFByRef(String ref) throws ManufacturingNotFoundException {
OrderManufacturing manufacturingOrder=manufacturingDao.findByRef(ref);
if(manufacturingOrder==null){
	throw new ManufacturingNotFoundException();
}  OrderManufacturingDTO manufacturingOrderDTO= mapper.map(manufacturingOrder, OrderManufacturingDTO.class);
	return manufacturingOrderDTO;
}
@Override
@Transactional(readOnly=true)
public List<OrderManufacturingDTO> getAllOF(int start, int length,
		String sorting, String filter) {
	List<OrderManufacturing>listEntity=manufacturingDao.getAllOF(start, length, sorting, filter);
	return DozerHelper.map(mapper, listEntity, OrderManufacturingDTO.class);
}
@Override
@Transactional(rollbackFor=Exception.class)
public long createOF(OrderManufacturingDTO OrderFacturing, UserDTO creator) {
OrderManufacturing OFEntity=mapper.map(OrderFacturing, OrderManufacturing.class);
	ServiceUtils.buildEntityModel(creator,OFEntity);
	OFEntity.setRef(ServiceUtils.TMP_REF);
	Long idOF=manufacturingDao.createOF(OFEntity);
	OFEntity.setId(idOF);
     OFEntity.generateReference();
	manufacturingDao.updateOF(OFEntity);
	return idOF;
}
@Override
@Transactional(rollbackFor=Exception.class)
public void updateOF(OrderManufacturingDTO OrderFacturing, UserDTO modifier) throws ManufacturingNotFoundException {
	OrderManufacturing OFEntity=mapper.map(OrderFacturing, OrderManufacturing.class);
    OrderManufacturing OFTmp= manufacturingDao.findById(OFEntity.getId());
    
   if( OFTmp==null){
	   throw new ManufacturingNotFoundException();
   }
   OFEntity.setRef(OFTmp.getRef());
   OFEntity.setCreator(OFTmp.getCreator());
   OFEntity.setCreateDate(OFTmp.getCreateDate());
    ServiceUtils.EditEntityModel(modifier,OFEntity);
    OFEntity.setDeleted(false);
    OFEntity.setLastEdit(new Date());
    OFEntity.setPicture(OFTmp.getPicture());
    OFEntity.setFiles(OFTmp.getFiles());
    OFEntity.setNomenclatures(OFTmp.getNomenclatures());
    OFEntity.setGammes(OFTmp.getGammes());
	manufacturingDao.updateOF(OFEntity);
}
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteOF(OrderManufacturingDTO OrderFacturing) {
	OrderManufacturing OFEntity=mapper.map(OrderFacturing, OrderManufacturing.class);
	OFEntity= new OrderManufacturing();
	OFEntity.setId(OrderFacturing.getId());
	manufacturingDao.deleteOF(OFEntity);
	
}
@Override
@Transactional(readOnly=true)
public long OrderFacturingCount(String filter) {
	
	return manufacturingDao.ManufacturingCount(filter);
}
@Override
@Transactional(rollbackFor=Exception.class)
public void updatePicture(FileDTO picture, long id, UserDTO modifier) throws ManufacturingNotFoundException {
	OrderManufacturing manufaturEntity= manufacturingDao.findById(id);
    if(manufaturEntity==null){
   	 throw new ManufacturingNotFoundException();
    }
    ServiceUtils.EditEntityModel(modifier, manufaturEntity);
    File file=new File();
    file.setId(picture.getId());
   File ImageToDelete=manufaturEntity.getPicture();
    manufaturEntity.setPicture(file);
    manufacturingDao.updateOF(manufaturEntity);;
    if(ImageToDelete!=null && ImageToDelete.getId()>0)
           fileDao.deleteFile(ImageToDelete);
	
}
@Override
@Transactional(rollbackFor=Exception.class)
public void attachFileToManufacturing(FileDTO fileDTO, long id, UserDTO modifier) throws ManufacturingNotFoundException {
	OrderManufacturing manufacturingEntity= manufacturingDao.findById(id);
    if(manufacturingEntity==null){
   	 throw new ManufacturingNotFoundException();
    }
    ServiceUtils.EditEntityModel(modifier,manufacturingEntity);
    File file=new File();
    file.setId(fileDTO.getId());
    manufacturingEntity.getFiles().add(file);
    manufacturingDao.updateOF(manufacturingEntity);
    
}
@Override
@Transactional(rollbackFor=Exception.class)
public void attachNomenclatureToManufacturing(NomenclatureDTO nomenclatureDTO,long id,UserDTO modifier) throws ManufacturingNotFoundException{
	OrderManufacturing manufacturingEntity= manufacturingDao.findById(id);
    if(manufacturingEntity==null){
   	 throw new ManufacturingNotFoundException();
    }
    ServiceUtils.EditEntityModel(modifier,manufacturingEntity);
    Nomenclature nomenclature=new Nomenclature();
    nomenclature.setId(nomenclatureDTO.getId());
    manufacturingEntity.getNomenclatures().add(nomenclature);
    manufacturingDao.updateOF(manufacturingEntity);
    
}
@Override
@Transactional(rollbackFor=Exception.class)
	public void deleteNomenclaturefromManufacturing(
			NomenclatureDTO nomenclatureDTO, long id, UserDTO modifier) throws ManufacturingNotFoundException {
	    Nomenclature nomenclature=new Nomenclature();
        nomenclature.setId(nomenclatureDTO.getId());
		OrderManufacturing manufacturingEntity = manufacturingDao.findById(id);
		if (manufacturingEntity == null) {
			throw new ManufacturingNotFoundException();
		}
		ServiceUtils.EditEntityModel(modifier, manufacturingEntity);
		Set<Nomenclature> setNomenclatures = manufacturingEntity
				.getNomenclatures();
		deleteNomenclatureFromSet(setNomenclatures, nomenclature);
		manufacturingEntity.setNomenclatures(setNomenclatures);
		manufacturingDao.updateOF(manufacturingEntity);
		nomenclatureDao.deleteNomenclature(nomenclature);
		
	}

private void deleteNomenclatureFromSet(Set<Nomenclature> setNomenclatures,Nomenclature nomenclature){
	Iterator<Nomenclature> it = setNomenclatures.iterator();
	Nomenclature nom=null;
	while (it.hasNext()) {
		nom=it.next();
       if(nom.getId()==nomenclature.getId()){
    	   setNomenclatures.remove(nom);
    	   return;
       }
	}
	
}
@Override
@Transactional(readOnly=true)
public List<UserDTO> searchResponsable(int lenght, int start, String search) {
	List<User>UserEntity= manufacturingDao.searchResponsable(lenght, start, search);
	return DozerHelper.map(mapper, UserEntity, UserDTO.class);
}
@Override
@Transactional(readOnly=true)
public List<WarehouseDTO> searchWarehouse(int lenght, int start, String search) {
	List<Warehouse>WarehouseEntity=manufacturingDao.searchCenter(lenght, start, search);
	return DozerHelper.map(mapper, WarehouseEntity, WarehouseDTO.class);
}
@Override
@Transactional(rollbackFor=Exception.class)
public void attachGammeToManufacturing(GammeDTO gammeDTO, long id,
		UserDTO modifier) throws ManufacturingNotFoundException {
	OrderManufacturing manufacturingEntity= manufacturingDao.findById(id);
    if(manufacturingEntity==null){
   	 throw new ManufacturingNotFoundException();
    }
    ServiceUtils.EditEntityModel(modifier,manufacturingEntity);
    Gamme gamme=new Gamme();
    gamme.setId(gammeDTO.getId());
    manufacturingEntity.getGammes().add(gamme);
    manufacturingDao.updateOF(manufacturingEntity);
	
}
private void deleteGammeFromSet(Set<Gamme> setGammes,Gamme gamme){
	Iterator<Gamme> it = setGammes.iterator();
	Gamme nom=null;
	while (it.hasNext()) {
		nom=it.next();
       if(nom.getId()==gamme.getId()){
    	   setGammes.remove(nom);
    	   return;
       }
       }
	}
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteGammefromManufacturing(GammeDTO gammeDTO, long id,
		UserDTO modifier) throws ManufacturingNotFoundException {
        Gamme gamme= new Gamme();
        gamme.setId(gammeDTO.getId());
		OrderManufacturing manufacturingEntity = manufacturingDao.findById(id);
		if (manufacturingEntity == null) {
			throw new ManufacturingNotFoundException();
		}
		ServiceUtils.EditEntityModel(modifier, manufacturingEntity);
		Set<Gamme> setGammes = manufacturingEntity.getGammes();
		deleteGammeFromSet(setGammes, gamme);
		manufacturingEntity.setGammes(setGammes);
		manufacturingDao.updateOF(manufacturingEntity);
		gammeDao.deleteGamme(gamme);
	
}	
@Transactional(readOnly=true)
@Override
public Map<String , Float> calculeCost(long id) throws ManufacturingNotFoundException{
	OrderManufacturing manufacturingEntity = manufacturingDao.findById(id);
	if (manufacturingEntity == null) {
		throw new ManufacturingNotFoundException();
	}
	Set<Nomenclature> nomenclatures=manufacturingEntity.getNomenclatures();
	Set<Gamme> gammes=manufacturingEntity.getGammes();
	Map<String, Float> map=new HashMap<String,Float>();
	map.put("thCost",calculeCostProductTh(nomenclatures)+calculeCostGammes(gammes));
	map.put("realCost",calculeCostProductReal(nomenclatures)+calculeCostGammes(gammes ));
	map.put("thUnitCost", map.get("thCost")/(float)manufacturingEntity.getRequeredQT());
	map.put("realUnitCost", map.get("realCost")/(float)manufacturingEntity.getRequeredQT());
	return map;
}
public static float calculeCostProductReal(Set<Nomenclature> nomenclatures){
	float cost=0;
	for (Nomenclature nomenclature : nomenclatures) {
		cost+=nomenclature.getProduct().getPrice()*nomenclature.getUsedQt();
	}
	return cost;
}
private float calculeCostProductTh(Set<Nomenclature> nomenclatures){
	float cost=0;
	for (Nomenclature nomenclature : nomenclatures) {
		cost+=nomenclature.getProduct().getPrice()*nomenclature.getRequeredQt();
	}
	return cost;
}
private float calculeCostGammes(Set<Gamme> gammes){
	float cost=0;
	for (Gamme gamme :gammes) {
		cost+=gamme.getNbposte()*gamme.getPoste().getPrice()*gamme.getTime();
	}
	return cost;
}
}
