package ma.esoftech.esoftrade.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.ProductQuantityDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.Dao.IProductDao;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductQuantity;
import ma.esoftech.esoftrade.service.IProductService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;

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
@Autowired
IFileDao fileDao;



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
	Long idPicture=fileDao.createFile(createDefaultPicture());
	File picture=new File();
	picture.setId(idPicture);
	productEntity.setPicture(picture);
	Long idProduc=productDao.createProduct(productEntity);
	productEntity.setId(idProduc);
     productEntity.generateReference();
	productDao.updateProduct(productEntity);
	return idProduc;
}
private File createDefaultPicture(){
	File picture=new File();
	picture.setCreateDate(new Date());
	picture.setDeleted(false);
	picture.setDescription("");
	picture.setLastEdit(new Date());
	picture.setLength(0);
	picture.setMask(000);
	picture.setName(FileUploadUTILS.DEFAULT_PICTURE_PRODUCT_NAME);
	picture.setPath(FileUploadUTILS.getPathFile()+"/"+FileUploadUTILS.DEFAULT_PICTURE_PRODUCT_NAME);
	picture.setType("png");
	return picture;
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
    productEntity.setPicture(producttmp.getPicture());
    productEntity.setFiles(producttmp.getFiles());
	productDao.updateProduct(productEntity);
}
@Transactional(rollbackFor=Exception.class)
public void attachFileToProduct(FileDTO fileDTO,long id,UserDTO modifier) throws ProductNotFoundException{
	Product productEntity=productDao.findById(id);
    if(productEntity==null){
   	 throw new ProductNotFoundException();
    }
    ServiceUtils.EditEntityModel(modifier, productEntity);
    File file=new File();
    file.setId(fileDTO.getId());
    productEntity.getFiles().add(file);
    productDao.updateProduct(productEntity);
}
@Transactional(rollbackFor=Exception.class)
public void updatePicture(FileDTO picture,long id,UserDTO modifier) throws ProductNotFoundException{
	Product productEntity=productDao.findById(id);
     if(productEntity==null){
    	 throw new ProductNotFoundException();
     }
     ServiceUtils.EditEntityModel(modifier, productEntity);
     File file=new File();
     file.setId(picture.getId());
    File ImageToDelete=productEntity.getPicture();
     productEntity.setPicture(file);
     productDao.updateProduct(productEntity);
     if(ImageToDelete!=null && ImageToDelete.getId()>0)
            fileDao.deleteFile(ImageToDelete);
}
@Override
@Transactional(rollbackFor=Exception.class)
public void deleteProduct(ProductDTO product) {
	Product productEntity= (Product) mapper.map(product, Product.class);
	productEntity=new Product();
	productEntity.setId(product.getId());
	productDao.deleteProduct(productEntity);
	
}
@Override
@Transactional(readOnly=true)
public long productCount(String filter) {
	return productDao.ProductCount(filter);
}
@Override
@Transactional(readOnly=true)
public List<ProductDTO> searchProducts(int lenght, int start,
		String search) {
	List<Product> listEntity=productDao.searchProducts(lenght, start, search);
	return DozerHelper.map(mapper, listEntity,ProductDTO.class);
}
@Override
@Transactional(readOnly=true)
public long getProductQuantity(ProductDTO product) {
    Product productEntity=new Product();
    productEntity.setId(product.getId());
	return productDao.getProductQuantity(productEntity);
}
@Override
@Transactional(readOnly=true)
public List<ProductQuantityDTO> getAllproductQauntity(int start, int length,
		String sorting) {
	List<ProductQuantity>list= productDao.getProductQuantityList(length, start, sorting);
	List<ProductQuantity> list2=new ArrayList<ProductQuantity>(list);
			
	Iterator<ProductQuantity> it=list2.iterator();
	//ProductQuantity entity=null;
	for(ProductQuantity entity :list){
		System.out.println(entity.getProduct().getAlertTreshold());
		if(entity.getQuantity()>entity.getProduct().getAlertTreshold())
		{
			list2.remove(entity);
			}
		}
	
	return DozerHelper.map(mapper,list2, ProductQuantityDTO.class);
}

}
