package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.PosteCategoryDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.Dao.IPosteCategoryDao;
import ma.esoftech.esoftrade.Dao.IPosteDao;
import ma.esoftech.esoftrade.Dao.IUserDao;
import ma.esoftech.esoftrade.exception.PosteNotFoundException;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;
import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.Poste;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.service.IPosteService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PosteServiceImpl  implements IPosteService{
	@Autowired
	Mapper mapper;
	@Autowired
	IPosteDao postedao;
	@Autowired
    IFileDao filedao;
	@Autowired
	IUserDao userdao;
	@Autowired
	IPosteCategoryDao categoryPoste;
	
	@Override
	@Transactional(readOnly=true)
	public PosteDTO findPosteById(Long id) throws PosteNotFoundException {
	Poste poste= postedao.findById(id);
	if(poste==null){
	  throw new PosteNotFoundException(id);
	} 
	PosteDTO postedto= mapper.map(poste, PosteDTO.class);
	return postedto;
	}
	@Override
	@Transactional(readOnly=true)
	public PosteDTO findPosteByRef(String ref) throws PosteNotFoundException {
		Poste poste= postedao.findByRef(ref);
	if(poste==null){
		  throw new PosteNotFoundException();
		} 
		PosteDTO postedto= mapper.map(poste, PosteDTO.class);
		return postedto;}
	
	@Override
	@Transactional(readOnly=true)
	public List<PosteDTO> getAllPoste(int start, int length, String sorting,
			String filter) {
		List<Poste>postListEntity=postedao.getAllPoste(start, length, sorting, filter);
		return DozerHelper.map(mapper, postListEntity, PosteDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<PosteDTO> getPosteByCategory(int start, int length,
			String sorting, PosteCategoryDTO category) {
		CategoryPoste catEntity= new CategoryPoste();
		catEntity.setId(category.getId());
		List<Poste>postListEntity=postedao.getPosteByCategory(start, length, sorting, catEntity);
		return DozerHelper.map(mapper, postListEntity, PosteDTO.class);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createPoste(PosteDTO poste, UserDTO creator) {
		Poste posteEntity=(Poste) mapper.map(poste, Poste.class);
		ServiceUtils.buildEntityModel(creator, posteEntity);
		posteEntity.setRef(ServiceUtils.TMP_REF);
		Long idPoste=postedao.createPoste(posteEntity);
		posteEntity.setId(idPoste);
	     posteEntity.generateReference();
		postedao.updatePoste(posteEntity);
		return idPoste;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updatePoste(PosteDTO poste, UserDTO modifier) throws PosteNotFoundException {
		Poste posteEntity= mapper.map(poste, Poste.class);
	    Poste posttmp=postedao.findById(posteEntity.getId());
	    
	   if(posttmp==null){
		   throw new PosteNotFoundException();
	   }
	    posteEntity.setRef(posttmp.getRef());
	    posteEntity.setCreator(posttmp.getCreator());
	    posteEntity.setCreateDate(posttmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, posteEntity);
	    posteEntity.setDeleted(false);
	    posteEntity.setLastEdit(new Date());
	    posteEntity.setFiles(posttmp.getFiles());
		postedao.updatePoste(posteEntity);
		
	}
	@Override
	@Transactional(readOnly=true)
	public long PosteCatCount(String filter) {
		long idreturned= postedao.PosteCount(filter);
		return idreturned;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deletePoste(PosteDTO poste) {
		Poste posteEntity= (Poste)mapper.map(poste, Poste.class);
		posteEntity=new Poste();
		posteEntity.setId(posteEntity.getId());
		postedao.deletePoste(posteEntity);
	}
	@Override
	@Transactional(readOnly=true)
	public long PosteCount(String filter) {
		return postedao.PosteCount(filter);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void attachFileToPoste(FileDTO fileDTO, long id, UserDTO modifier) throws PosteNotFoundException {
		Poste postEntity= postedao.findById(id);
		if(postEntity==null){
		   	 throw new PosteNotFoundException();
		    }
		    ServiceUtils.EditEntityModel(modifier, postEntity);
		    File file=new File();
		    file.setId(fileDTO.getId());
		    postEntity.getFiles().add(file);
		    postedao.updatePoste(postEntity);
		
	}
	@Override
	@Transactional(readOnly=true)
	public List<PosteDTO> searchPoste(int lenght, int start, String search) {
		List<Poste>postListEntity=postedao.searchPoste(lenght, start, search);
		return DozerHelper.map(mapper, postListEntity, PosteDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<UserDTO> getListUserByPoste(int lenght, int start, String sorting,
			String filter, PosteDTO poste) {
		Poste postEntity= new Poste();
		postEntity.setId(poste.getId());
		List<User>postListEntity=postedao.getListUserByPoste(lenght, start, sorting, filter, postEntity);
		return DozerHelper.map(mapper, postListEntity, UserDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public long UserCount(String filter,PosteDTO poste) {
		Poste postEntity= new Poste();
		postEntity.setId(poste.getId());
		return postedao.UserCount(filter, postEntity);
	}
}
