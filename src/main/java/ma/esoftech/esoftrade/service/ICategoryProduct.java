package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;

public interface ICategoryProduct {

	public List<PCategoryDTO> getListCtagory(int start, int length);
}
