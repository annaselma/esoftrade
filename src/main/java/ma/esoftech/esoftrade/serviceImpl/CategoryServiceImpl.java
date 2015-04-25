package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.Dao.ICategoryProductDao;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;
import ma.esoftech.esoftrade.service.ICategoryProduct;

@Service
public class CategoryServiceImpl implements ICategoryProduct {

	@Autowired
	ICategoryProductDao categoryDao;
	
	@Autowired
	Mapper mapper;
	@Transactional(readOnly=true)
	@Override
	public List<PCategoryDTO> getListCtagory(
			int start, int length) {
		List<ProductCategory> listEntity= categoryDao.getListCategory(start, length);
		List<PCategoryDTO>productCategoryDTOList= new ArrayList<PCategoryDTO>(); 
		for (ProductCategory category : listEntity) {
			productCategoryDTOList.add(mapper.map(category, PCategoryDTO.class));
		}
		return productCategoryDTOList;
	}

}
