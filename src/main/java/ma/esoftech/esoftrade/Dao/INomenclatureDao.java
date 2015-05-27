package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.exception.NomenclatureNotFoundException;
import ma.esoftech.esoftrade.model.Nomenclature;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.Warehouse;

public interface INomenclatureDao {
	
	public long createNomenclature(Nomenclature nomenclature);
	public void updateNomenclature(Nomenclature nomenclature) ;
	public void deleteNomenclature(Nomenclature nomenclature);
	public Nomenclature findNomenclatureById(long id);
	public List<Nomenclature> getNomenclaturesByManufacturing(int start, int length,
			String sorting, String filter,OrderManufacturing manufacturing);
	public long  nomenclatureCountByManufacturing(String filter,OrderManufacturing manufacturing);
	long getImportedQte(Product product, Warehouse warehouse);
	

}
