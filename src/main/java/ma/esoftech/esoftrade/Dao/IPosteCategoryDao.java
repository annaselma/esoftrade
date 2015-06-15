package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.Poste;
public interface IPosteCategoryDao {
	public CategoryPoste findById(long id);
	public CategoryPoste findByname(String name);
	public List<CategoryPoste>getListCategory(int start, int length, String sorting, String filter);
	public List<CategoryPoste>getListCategory(int start, int length);
    public long createCategory(CategoryPoste category);
    public void updateCategory(CategoryPoste category);
    public void deleteCategory(CategoryPoste category);
    public long categoryCount(String filter);
    public List<Poste> getListPosteBycategory(int lenght, int start, String sorting,String filter,CategoryPoste category);
    public List<CategoryPoste> searchPosteCategories(int lenght,int start,String search);
    public long posteCountBycategory(String filter, CategoryPoste category);
}
