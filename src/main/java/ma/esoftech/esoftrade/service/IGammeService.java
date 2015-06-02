package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.GammeDTO;
import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.GammeNotFoundException;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;

public interface IGammeService {
	public long createGamme(GammeDTO gammeDTO, UserDTO creator);
	public void updateGamme(GammeDTO gammeDTO, UserDTO modifier) throws GammeNotFoundException;
	public void deleteNomenclature(GammeDTO gammeDTO) throws GammeNotFoundException;
	public  GammeDTO findById(long id) throws GammeNotFoundException;
	public List<GammeDTO> getGammeByManufacturing(int start,
			int length, String sorting, String filter,OrderManufacturingDTO manufacturing);
	public long gammeCountByManufacturing(String filter,
			OrderManufacturingDTO manufacturing);
	public void attachFileToGamme(FileDTO fileDTO,long id,UserDTO modifier) throws GammeNotFoundException;
}
