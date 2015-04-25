package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IProductDao;
import ma.esoftech.esoftrade.exeption.ProductNotFoundException;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.service.IProductService;
import ma.esoftech.esoftrade.service.ServiceUtils;

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
public ProductDTO findProductById(Long id) throws ProductNotFoundException {
	
	Product product= productDao.findById(id);
	if(product==null){
		throw new ProductNotFoundException(id);
	}
	ProductDTO productFinal= mapper.map(product, ProductDTO.class);
	return productFinal;
}
@Override
@Transactional(readOnly=true)
public ProductDTO findProductByRef(String ref) throws ProductNotFoundException {
	Product product= productDao.findByRef(ref);
	if(product==null){
		throw new ProductNotFoundException();
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
@Transactional(rollbackFor=Exception.class)
public long createProduct(ProductDTO product, UserDTO creator) {
	// TODO Auto-generated method stub to continue
	Product productEntity=(Product) mapper.map(product, Product.class);
	ServiceUtils.buildEntityModel(creator, productEntity);
	productEntity.setRef(ServiceUtils.TMP_REF);
	Long idProduc=productDao.createProduct(productEntity);
	productEntity.setId(idProduc);
     productEntity.generateReference();
	productDao.updateProduct(productEntity);
	return idProduc;
}
@Override
@Transactional(rollbackFor=Exception.class)
public void updateProduct(ProductDTO product, UserDTO modifier) throws ProductNotFoundException {
	Product productEntity= mapper.map(product, Product.class);
    Product producttmp=productDao.findById(productEntity.getId());
    
   if(producttmp==null){
	   throw new ProductNotFoundException();
   }
    productEntity.setRef(producttmp.getRef());
    productEntity.setCreator(producttmp.getCreator());
    productEntity.setCreateDate(producttmp.getCreateDate());
    ServiceUtils.EditEntityModel(modifier, productEntity);
    productEntity.setDeleted(false);
    productEntity.setLastEdit(new Date());
	productDao.updateProduct(productEntity);
}
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteProduct(ProductDTO product) {
	Product productEntity= (Product) mapper.map(product, Product.class);
	productEntity=new Product();
	productEntity.setId(product.getId());
	System.out.println("id houwa"+productEntity.getId());
	productDao.deleteProduct(productEntity);
	
}
@Override
@Transactional(readOnly=true)
public long productCount(String filter) {

	return productDao.ProductCount(filter);
}

}
