package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.ICategoryProductDao;
import ma.esoftech.esoftrade.DaoImp.ProductDao;
import ma.esoftech.esoftrade.exception.PCatNotFoundException;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;
import ma.esoftech.esoftrade.service.ICategoryProduct;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

@Service
public class CategoryServiceImpl implements ICategoryProduct {

	@Autowired
	ICategoryProductDao categoryDao;
	
	@Autowired
	Mapper mapper;
	
	@Override
	@Transactional(readOnly=true)
	public PCategoryDTO findById(long id) throws PCatNotFoundException {
		ProductCategory category= categoryDao.findById(id);
		if(category==null){
			throw new PCatNotFoundException(id);}
		PCategoryDTO categoryDTO= mapper.map(category, PCategoryDTO.class);
		return categoryDTO;
	}
	@Override
	@Transactional(readOnly=true)
	public PCategoryDTO findByname(String name) throws PCatNotFoundException {
		ProductCategory category= categoryDao.findByname(name);
		if(category== null){
			throw new PCatNotFoundException(name);
		}
		PCategoryDTO categoryDTO= mapper.map(category, PCategoryDTO.class);
		return categoryDTO;
	}
	@Override
	@Transactional(readOnly=true)
	public List<PCategoryDTO> getListCategory(int start, int length,
			String sorting, String filter) {
	List<ProductCategory> categoryEntity= categoryDao.getListCategory(start, length, sorting, filter);
	List<PCategoryDTO>categoryListDTO= new ArrayList<PCategoryDTO>();
	for (ProductCategory category : categoryEntity) {
		categoryListDTO.add(mapper.map(category, PCategoryDTO.class));
		
	}
		return categoryListDTO;
	}
	@Override
	@Transactional(readOnly=true)
	public List<PCategoryDTO> getListCategory(int start, int length) {
		List<ProductCategory> listEntity= categoryDao.getListCategory(start, length);
		List<PCategoryDTO>productCategoryDTOList= new ArrayList<PCategoryDTO>(); 
		for (ProductCategory category : listEntity) {
			productCategoryDTOList.add(mapper.map(category, PCategoryDTO.class));
		}
		return productCategoryDTOList;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createCategory(PCategoryDTO category, UserDTO creator) {
		ProductCategory categoryEntity= mapper.map(category, ProductCategory.class);
		ServiceUtils.buildEntityModel(creator, categoryEntity);
		long idCategory= categoryDao.createCategory(categoryEntity);
		categoryEntity.setId(idCategory);
		categoryDao.updateCategory(categoryEntity);
		return idCategory;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateCategory(PCategoryDTO category, UserDTO modifier) throws PCatNotFoundException {
		ProductCategory categoryEntity= mapper.map(category, ProductCategory.class);
	    ProductCategory categorytmp=categoryDao.findById(categoryEntity.getId());
	    
	   if(categorytmp==null){
		   throw new PCatNotFoundException();
	   }
	    categoryEntity.setCreator(categorytmp.getCreator());
	    categoryEntity.setCreateDate(categorytmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, categoryEntity);
	    categoryEntity.setDeleted(false);
	    categoryEntity.setLastEdit(new Date());
		categoryDao.updateCategory(categoryEntity);
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteCategory(PCategoryDTO category) {
	ProductCategory categoryEntity= mapper.map(category, ProductCategory.class);	
	categoryEntity= new ProductCategory();
	categoryEntity.setId(category.getId());
	categoryDao.deleteCategory(categoryEntity);
	}
	
	@Override
	@Transactional(readOnly=true)
	public long categoryCount(String filter) {
		// TODO Auto-generated method stub
		return categoryDao.categoryCount(filter);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ProductDTO> getListProductBycategory(int lenght, int start,String sorting, String filter, PCategoryDTO category) {
			ProductCategory categoryEntity= mapper.map(category, ProductCategory.class);
			List<Product>ListProductEntity= categoryDao.getListProductBycategory(lenght, start, sorting, filter, categoryEntity);
			List<ProductDTO>ListProductDTO= new ArrayList<ProductDTO>();
			for (Product product : ListProductEntity) {
				ListProductDTO.add(mapper.map(product, ProductDTO.class));
			}
			return ListProductDTO;
	}
	@Override
	@Transactional(readOnly=true)
	public long productCountBycategory(String filter, PCategoryDTO category) {
		// TODO Auto-generated method stub
		ProductCategory categoryEntity= mapper.map(category, ProductCategory.class);	
		categoryEntity= new ProductCategory();
		categoryEntity.setId(category.getId());
		return categoryDao.productCountBycategory(filter, categoryEntity);
	}
	@Override
	public List<PCategoryDTO> searchProductCategories(int lenght, int start,
			String search) {
		List<ProductCategory> listEntity=categoryDao.searchProductCategories(lenght, start, search);
		return DozerHelper.map(mapper, listEntity,PCategoryDTO.class);
	}

	
	
}
