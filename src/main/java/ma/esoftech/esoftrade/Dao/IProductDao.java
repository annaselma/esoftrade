package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;

public interface IProductDao {

	public Product findById(long id);
	public Product findByRef(String ref);
	public List<Product> getAllProducts(int start, int length, String sorting, String filter);
	public List<Product>getProductByCategory(int start, int length, String sorting, ProductCategory category);
	public long createProduct(Product produit);
	public void updateProduct(Product produit);
	public void deleteProduct(Product produit);
	public long ProductCount(String filter);
	public long getProductQuantity(Product product);
	List<Product> searchProducts(int lenght, int start, String search);
}
