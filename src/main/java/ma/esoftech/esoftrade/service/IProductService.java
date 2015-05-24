package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;

public interface IProductService {

	public ProductDTO findProductById(Long id) throws ProductNotFoundException ;
	public ProductDTO findProductByRef(String ref) throws ProductNotFoundException ;
	public List<ProductDTO> getAllproduct(int start, int length,String sorting, String filter);
	public long createProduct(ProductDTO product, UserDTO creator);
	public void updateProduct(ProductDTO product, UserDTO modifier)throws ProductNotFoundException;
	public void deleteProduct(ProductDTO product);
	public long productCount(String filter);
	public void updatePicture(FileDTO picture,long id,UserDTO modifier) throws ProductNotFoundException;	
	public void attachFileToProduct(FileDTO fileDTO,long id,UserDTO modifier) throws ProductNotFoundException;
	public List<ProductDTO> searchProducts(int lenght, int start, String search);
	public long getProductQuantity(ProductDTO product);
}
