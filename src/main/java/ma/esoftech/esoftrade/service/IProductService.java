package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;

public interface IProductService {

	public ProductDTO findProductById(Long id);
	public ProductDTO findProductByRef(String ref);
	public List<ProductDTO> getAllproduct(int start, int length,String sorting, String filter);
	public long createProduct(ProductDTO product, UserDTO creator);
	public void updateProduct(ProductDTO product, UserDTO modifier);
	public void deleteProduct(ProductDTO product);
	public String userCount(String filter);}
