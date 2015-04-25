package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.ProductCategory;

public interface ICategoryProductDao {

	
	public List<ProductCategory>getListCategory(int start, int length, String sorting, String filter);
	public List<ProductCategory>getListCategory(int start, int length);

}
