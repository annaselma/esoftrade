package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.DTO.PosteCategoryDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.Dao.IPosteCategoryDao;
import ma.esoftech.esoftrade.Dao.IPosteDao;
import ma.esoftech.esoftrade.Dao.IUserDao;
import ma.esoftech.esoftrade.exception.PosteNotFoundException;
import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.Poste;
import ma.esoftech.esoftrade.service.ICategoryPostService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryPosteSerImpl implements ICategoryPostService{
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
	public PosteCategoryDTO findById(long id) throws PosteNotFoundException {
	CategoryPoste catPoste= categoryPoste.findById(id);
		if(catPoste==null){
		  throw new PosteNotFoundException(id);
		} 
		PosteCategoryDTO posteCdto= mapper.map(catPoste, PosteCategoryDTO.class);
		return posteCdto;
	}

	@Override
	@Transactional(readOnly=true)
	public PosteCategoryDTO findByname(String name) throws PosteNotFoundException {
		CategoryPoste catPoste= categoryPoste.findByname(name);
		if(catPoste==null){
		  throw new PosteNotFoundException();
		} 
		PosteCategoryDTO posteCdto= mapper.map(catPoste, PosteCategoryDTO.class);
		return posteCdto;
	}

	@Override
	@Transactional(readOnly=true)
	public List<PosteCategoryDTO> getListCategory(int start, int length,
			String sorting, String filter) {
		List<CategoryPoste>postCatEntity=categoryPoste.getListCategory(start, length, sorting, filter);
		return DozerHelper.map(mapper, postCatEntity, PosteCategoryDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PosteCategoryDTO> getListCategory(int start, int length) {
		List<CategoryPoste>postCatEntity= categoryPoste.getListCategory(start, length);
		return DozerHelper.map(mapper, postCatEntity, PosteCategoryDTO.class);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createCategory(PosteCategoryDTO category,UserDTO creator) {
		CategoryPoste CatposteEntity=(CategoryPoste) mapper.map(category, CategoryPoste.class);
		ServiceUtils.buildEntityModel(creator, CatposteEntity);
		Long idPoste=categoryPoste.createCategory(CatposteEntity);
		CatposteEntity.setId(idPoste);
		categoryPoste.updateCategory(CatposteEntity);
		return idPoste;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateCategory(PosteCategoryDTO category,UserDTO modifier) throws PosteNotFoundException {
	CategoryPoste CatposteEntity=(CategoryPoste) mapper.map(category, CategoryPoste.class);
	CategoryPoste cattmp= categoryPoste.findById(CatposteEntity.getId());	
	if(cattmp==null){
		   throw new PosteNotFoundException();
	   }
	CatposteEntity.setCreator(cattmp.getCreator());
	CatposteEntity.setCreateDate(cattmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, CatposteEntity);
	    CatposteEntity.setDeleted(false);
	    CatposteEntity.setLastEdit(new Date());
	    categoryPoste.updateCategory(CatposteEntity);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteCategory(PosteCategoryDTO category) {
		CategoryPoste catEntity= mapper.map(category, CategoryPoste.class);
		catEntity= new CategoryPoste();
		catEntity.setId(category.getId());
		categoryPoste.deleteCategory(catEntity);
	     
		
	}

	@Override
	@Transactional(readOnly=true)
	public long categoryCount(String filter) {
		return categoryPoste.categoryCount(filter);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PosteDTO> getListPosteBycategory(int lenght, int start,
			String sorting, String filter, PosteCategoryDTO category) {
		CategoryPoste categoryEntity= new CategoryPoste();
		categoryEntity.setId(category.getId());
		List<Poste>catEntity= categoryPoste.getListPosteBycategory(lenght, start, sorting, filter, categoryEntity);
		return DozerHelper.map(mapper, catEntity, PosteDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<PosteCategoryDTO> searchPosteCategories(int lenght, int start,
			String search) {
		List<CategoryPoste>catList= categoryPoste.searchPosteCategories(lenght, start, search);
		return DozerHelper.map(mapper, catList, PosteCategoryDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public long posteCountBycategory(String filter, PosteCategoryDTO category) {
		CategoryPoste catEntity= new CategoryPoste();
		catEntity.setId(category.getId());
		return categoryPoste.posteCountBycategory(filter, catEntity);
	}

}
