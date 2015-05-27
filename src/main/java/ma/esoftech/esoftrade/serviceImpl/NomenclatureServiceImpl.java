package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.Dao.INomenclatureDao;
import ma.esoftech.esoftrade.exception.NomenclatureNotFoundException;
import ma.esoftech.esoftrade.model.Nomenclature;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;
import ma.esoftech.esoftrade.service.INomenclatureService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NomenclatureServiceImpl implements INomenclatureService {

	@Autowired
	private INomenclatureDao nomenclatureDao;
	@Autowired
	Mapper mapper;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createNomenclature(NomenclatureDTO nomenclatureDTO, UserDTO creator) {
		Nomenclature nomenclatureEntity=mapper.map(nomenclatureDTO, Nomenclature.class);
		System.out.println(creator.getId());
		ServiceUtils.buildEntityModel(creator, nomenclatureEntity);
		nomenclatureEntity.setRef(ServiceUtils.TMP_REF);
		long idNomenclature=nomenclatureDao.createNomenclature(nomenclatureEntity);
		nomenclatureEntity.setId(idNomenclature);
		nomenclatureEntity.generateReference();
		nomenclatureDao.updateNomenclature(nomenclatureEntity);
		return idNomenclature;
	}
	

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateNomenclature(NomenclatureDTO nomenclatureDTO, UserDTO editor)
			throws NomenclatureNotFoundException {
		Nomenclature nomenclatureEntity=mapper.map(nomenclatureDTO, Nomenclature.class);
		Nomenclature nomenclatureTmp=nomenclatureDao.findNomenclatureById(nomenclatureEntity.getId());
		if(nomenclatureTmp==null){
			throw new NomenclatureNotFoundException(nomenclatureEntity.getId());
		}
		nomenclatureEntity.setRef(nomenclatureTmp.getRef());
		nomenclatureEntity.setCreator(nomenclatureTmp.getCreator());
		nomenclatureEntity.setCreateDate(nomenclatureTmp.getCreateDate());
	    ServiceUtils.EditEntityModel(editor, nomenclatureEntity);
	    nomenclatureEntity.setDeleted(false);
	    nomenclatureEntity.setLastEdit(new Date());
	    nomenclatureDao.updateNomenclature(nomenclatureEntity);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteNomenclature(NomenclatureDTO nomenclatureDTO)
			throws NomenclatureNotFoundException {
		Nomenclature nomenclatureEntity=mapper.map(nomenclatureDTO, Nomenclature.class);
		if(nomenclatureDao.findNomenclatureById(nomenclatureEntity.getId())==null){
			throw new NomenclatureNotFoundException(nomenclatureEntity.getId());
		}
		nomenclatureDao.deleteNomenclature(nomenclatureEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public NomenclatureDTO findById(long id)
			throws NomenclatureNotFoundException {
		Nomenclature nomenclature=nomenclatureDao.findNomenclatureById(id);
		if(nomenclature==null){
			throw new NomenclatureNotFoundException(id);
		}
		return mapper.map(nomenclature, NomenclatureDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<NomenclatureDTO> getNomenclaturesByManufacturing(int start,
			int length, String sorting, String filter,
			OrderManufacturingDTO manufacturing) {
		OrderManufacturing manufacturingEntity=new OrderManufacturing();
		manufacturingEntity.setId(manufacturing.getId());
		List<Nomenclature> listEntity=nomenclatureDao.getNomenclaturesByManufacturing(start, length, sorting, filter, manufacturingEntity);
		return DozerHelper.map(mapper, listEntity,NomenclatureDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public long nomenclatureCountByManufacturing(String filter,
			OrderManufacturingDTO manufacturing) {
		OrderManufacturing manufacturingEntity=new OrderManufacturing();
		manufacturingEntity.setId(manufacturing.getId());
		return nomenclatureDao.nomenclatureCountByManufacturing(filter, manufacturingEntity);
	}
	@Override
	@Transactional(readOnly=true)
	public long getImportedQte(ProductDTO product, WarehouseDTO warehouse){
		Product pr=new Product();
		Warehouse wh=new Warehouse();
		pr.setId(product.getId());
		wh.setId(warehouse.getId());
		return nomenclatureDao.getImportedQte(pr,wh);
	}

}
