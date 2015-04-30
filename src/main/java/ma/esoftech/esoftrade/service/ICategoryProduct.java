package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exeption.PCatNotFoundException;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;

public interface ICategoryProduct {

	public PCategoryDTO findById(long id) throws PCatNotFoundException;
	public PCategoryDTO findByname(String name)throws PCatNotFoundException;
	public List<PCategoryDTO>getListCategory(int start, int length, String sorting, String filter);
	public List<PCategoryDTO>getListCategory(int start, int length);
    public long createCategory(PCategoryDTO category, UserDTO creator);
    public void updateCategory(PCategoryDTO category, UserDTO modifier)throws PCatNotFoundException;
    public void deleteCategory(PCategoryDTO category);
    public long categoryCount(String filter);
}
