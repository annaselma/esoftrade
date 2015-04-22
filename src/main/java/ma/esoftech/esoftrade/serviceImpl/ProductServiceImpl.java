package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IProductDao;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.service.IProductService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements IProductService{
@Autowired
Mapper mapper;
@Autowired
IProductDao productDao;



@Override
@Transactional(readOnly=true)
public ProductDTO findProductById(Long id) {
	
	Product product= productDao.findById(id);
	if(product==null){
		return null;
	}
	ProductDTO productFinal= mapper.map(product, ProductDTO.class);
	return productFinal;
}
@Override
@Transactional(readOnly=true)
public ProductDTO findProductByRef(String ref) {
	Product product= productDao.findByRef(ref);
	if(product==null){
		return null;
	}
	ProductDTO productFinal= mapper.map(product, ProductDTO.class);
	
	return productFinal;
}

@Override
@Transactional(readOnly=true)
public List<ProductDTO> getAllproduct(int start, int length, String sorting,
		String filter) {
	
	List<Product>productEntity= productDao.getAllProducts(start, length, sorting, filter);
	List<ProductDTO>productDTOList= new ArrayList<ProductDTO>(); 
	for (Product produit : productEntity) {
		productDTOList.add((ProductDTO)mapper.map(produit, ProductDTO.class));
	}
	return productDTOList;
}
@Override
public long createProduct(ProductDTO product, UserDTO creator) {
	// TODO Auto-generated method stub to continue
	
	return 0;
}
@Override
public void updateProduct(ProductDTO product, UserDTO modifier) {
	// TODO Auto-generated method stub
	
}
@Override
public void deleteProduct(ProductDTO product) {
	// TODO Auto-generated method stub
	
}
@Override
public String userCount(String filter) {
	// TODO Auto-generated method stub
	return null;
}

}
