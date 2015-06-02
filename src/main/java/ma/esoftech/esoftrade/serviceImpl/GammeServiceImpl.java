package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.GammeDTO;
import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IGammeDao;
import ma.esoftech.esoftrade.exception.GammeNotFoundException;
import ma.esoftech.esoftrade.exception.NomenclatureNotFoundException;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.Gamme;
import ma.esoftech.esoftrade.model.Nomenclature;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.service.IGammeService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GammeServiceImpl implements IGammeService {
	@Autowired
	private IGammeDao gammedao;
	@Autowired
	Mapper mapper;
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createGamme(GammeDTO gammeDTO, UserDTO creator) {
		Gamme gammeEntity= mapper.map(gammeDTO, Gamme.class);
		System.out.println(creator.getId());
		ServiceUtils.buildEntityModel(creator, gammeEntity);
		gammeEntity.setRef(ServiceUtils.TMP_REF);
		long idGamme=gammedao.createGamme(gammeEntity);
		gammeEntity.setId(idGamme);
		gammeEntity.generateReference();
		gammedao.updateGamme(gammeEntity);
		return idGamme;
		}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateGamme(GammeDTO gammeDTO, UserDTO modifier) throws GammeNotFoundException {
		Gamme gammeEntity= mapper.map(gammeDTO, Gamme.class);
		Gamme gammeTmp=gammedao.findGammeById(gammeEntity.getId());
		if(gammeTmp==null){
			throw new GammeNotFoundException(gammeEntity.getId());
		}
		gammeEntity.setRef(gammeTmp.getRef());
		gammeEntity.setCreator(gammeTmp.getCreator());
		gammeEntity.setCreateDate(gammeTmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, gammeEntity);
	    gammeEntity.setDeleted(false);
	    gammeEntity.setLastEdit(new Date());
	    gammedao.updateGamme(gammeEntity);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public GammeDTO findById(long id) throws GammeNotFoundException {
   Gamme gammeEntity=gammedao.findGammeById(id);
		if(gammeEntity==null){
			throw new GammeNotFoundException(id);
		}return mapper.map(gammeEntity, GammeDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<GammeDTO> getGammeByManufacturing(int start, int length,
			String sorting, String filter, OrderManufacturingDTO manufacturing) {
		OrderManufacturing manufacturingEntity=new OrderManufacturing();
		manufacturingEntity.setId(manufacturing.getId());
		List<Gamme> listEntity=gammedao.getGammeByManufacturing(start, length, sorting, filter, manufacturingEntity);
		return DozerHelper.map(mapper, listEntity,GammeDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public long gammeCountByManufacturing(String filter,
			OrderManufacturingDTO manufacturing) {
		OrderManufacturing manufacturingEntity=new OrderManufacturing();
		manufacturingEntity.setId(manufacturing.getId());
		return gammedao.GammeCountByManufacturing(filter, manufacturingEntity);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteNomenclature(GammeDTO gammeDTO) throws GammeNotFoundException {
		Gamme gammeEntity= mapper.map(gammeDTO, Gamme.class);
		if(gammedao.findGammeById(gammeEntity.getId())==null){
			throw new GammeNotFoundException(gammeEntity.getId());
		} gammedao.deleteGamme(gammeEntity);
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void attachFileToGamme(FileDTO fileDTO, long id, UserDTO modifier)
			throws GammeNotFoundException {
		Gamme gammeEntity=gammedao.findGammeById(id);
	    if(gammeEntity==null){
	   	 throw new GammeNotFoundException();
	    }
	    ServiceUtils.EditEntityModel(modifier, gammeEntity);
	    File file=new File();
	    file.setId(fileDTO.getId());
	    gammeEntity.getFiles().add(file);
	    gammedao.updateGamme(gammeEntity);
		
	}
}
