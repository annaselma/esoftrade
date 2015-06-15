package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.PosteCategoryDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.PosteNotFoundException;
public interface ICategoryPostService {
	public PosteCategoryDTO findById(long id) throws PosteNotFoundException;
	public PosteCategoryDTO findByname(String name) throws PosteNotFoundException;
	public List<PosteCategoryDTO>getListCategory(int start, int length, String sorting, String filter);
	public List<PosteCategoryDTO>getListCategory(int start, int length);
    public long createCategory(PosteCategoryDTO category,UserDTO creator);
    public void updateCategory(PosteCategoryDTO category,UserDTO modifier) throws PosteNotFoundException;
    public void deleteCategory(PosteCategoryDTO category);
    public long categoryCount(String filter);
    public List<PosteDTO> getListPosteBycategory(int lenght, int start, String sorting,String filter,PosteCategoryDTO category);
    public List<PosteCategoryDTO> searchPosteCategories(int lenght,int start,String search);
    public long posteCountBycategory(String filter, PosteCategoryDTO category);
}
