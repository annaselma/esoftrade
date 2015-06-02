package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Gamme;
import ma.esoftech.esoftrade.model.OrderManufacturing;

public interface IGammeDao {
	public long createGamme(Gamme gamme);
	public void updateGamme(Gamme gamme);
	public void deleteGamme(Gamme gamme);
	public Gamme findGammeById(long id);
	public List<Gamme> getGammeByManufacturing(int start, int length,
			String sorting, String filter,OrderManufacturing manufacturing);
	public long  GammeCountByManufacturing(String filter,OrderManufacturing manufacturing);
	
}
