package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.Poste;
import ma.esoftech.esoftrade.model.User;
public interface IPosteDao {
	public Poste findById(long id);
	public Poste findByRef(String ref);
	public Poste findByName(String namePoste);
	public List<Poste> getAllPoste(int start, int length, String sorting, String filter);
	public List<Poste>getPosteByCategory(int start, int length, String sorting, CategoryPoste category);
	public long createPoste(Poste poste);
	public void updatePoste(Poste poste);
	public void deletePoste(Poste poste);
	public long PosteCount(String filter);
	List<Poste> searchPoste(int lenght, int start, String search);
	public List<User> getListUserByPoste(int lenght, int start,String sorting, String filter, Poste poste);
	public long UserCount(String filter);
}
