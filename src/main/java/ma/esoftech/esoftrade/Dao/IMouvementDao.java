package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Mouvement;
import ma.esoftech.esoftrade.model.Warehouse;

public interface IMouvementDao {
public Mouvement FindByID(long id);
public long createMouvement(Mouvement mouvement);
public List<Mouvement>getListMouvement(int start, int length, String sorting, String filter);
public long MouvementCount(String filter);
public List<Mouvement>getListMouvementByWarehouse(int start, int length, String sorting, String filter,Warehouse warehouse);
public long MouvementCountByWarehouse(String filter,Warehouse warehouse);

}
