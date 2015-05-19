package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.controller.editor.CategoryProductEditor;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;

public interface ICategoryProductDao {

	public ProductCategory findById(long id);
	public ProductCategory findByname(String name);
	public List<ProductCategory>getListCategory(int start, int length, String sorting, String filter);
	public List<ProductCategory>getListCategory(int start, int length);
    public long createCategory(ProductCategory category);
    public void updateCategory(ProductCategory category);
    public void deleteCategory(ProductCategory category);
    public long categoryCount(String filter);
    public List<Product> getListProductBycategory(int lenght, int start, String sorting,String filter,ProductCategory category);
    public List<ProductCategory> searchProductCategories(int lenght,int start,String search);
    public long productCountBycategory(String filter, ProductCategory category);
}
