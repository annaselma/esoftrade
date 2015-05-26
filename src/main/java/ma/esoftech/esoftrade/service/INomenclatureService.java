package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.exception.NomenclatureNotFoundException;

public interface INomenclatureService {
public long createNomenclature(NomenclatureDTO nomenclatureDTO, UserDTO creator);
public void updateNomenclature(NomenclatureDTO nomenclatureDTO, UserDTO creator) throws NomenclatureNotFoundException;
public void deleteNomenclature(NomenclatureDTO nomenclatureDTO)throws NomenclatureNotFoundException;
public  NomenclatureDTO findById(long id)throws NomenclatureNotFoundException;
public List<NomenclatureDTO> getNomenclaturesByManufacturing(int start,
		int length, String sorting, String filter,OrderManufacturingDTO manufacturing);
public long nomenclatureCountByManufacturing(String filter,
		OrderManufacturingDTO manufacturing);
long getImportedQte(ProductDTO product, WarehouseDTO warehouse);
}
