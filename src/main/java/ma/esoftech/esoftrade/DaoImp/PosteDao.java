package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IPosteDao;
import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.Poste;
import ma.esoftech.esoftrade.model.User;

@Repository
public class PosteDao implements IPosteDao{
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public Poste findById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select post From Poste as post left join fetch post.category where post.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		Poste poste= (Poste)query.uniqueResult();
		
			return poste;
	}

	@Override
	public Poste findByRef(String ref) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select post From Poste as post left join fetch post.category where post.ref= :ref";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setString("ref", ref);
		Poste poste= (Poste)query.uniqueResult();
		
			return poste;
	}

	@Override
	public Poste findByName(String namePoste) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select post From Poste as post left join fetch post.category where post.name= :name";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setString("name", namePoste);
		Poste poste= (Poste)query.uniqueResult();
		
			return poste;
	}

	@Override
	public List<Poste> getAllPoste(int start, int length, String sorting,
			String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From Poste as post order by post."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Poste>poste=query.list();
		return poste;
	}

	@Override
	public List<Poste> getPosteByCategory(int start, int length,
			String sorting, CategoryPoste category) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="Select poste From Poste as poste inner join poste.category as category  where category=:cat"
	     		+ "order by product."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setParameter("cat", category);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Poste>poste=query.list();
		return poste;
	}

	@Override
	public long createPoste(Poste poste) {
		session=sessionFactory.getCurrentSession();
		long idreturned= (long)session.save(poste);
		return idreturned;
	}

	@Override
	public void updatePoste(Poste poste) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(poste);
		
	}

	@Override
	public void deletePoste(Poste poste) {
		session= sessionFactory.getCurrentSession();
		session.delete(poste);
		
	}

	@Override
	public long PosteCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(post) from Poste as post").uniqueResult();
		return count;
	}

	@Override
	public List<Poste> searchPoste(int lenght, int start, String search) {
		session=sessionFactory.getCurrentSession();
		String hql="select post From Poste as post where post.name like :search";
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}
	public PosteDao() {

	}

	@Override
	public List<User> getListUserByPoste(int lenght, int start, String sorting,
			String filter, Poste poste) {
		session= sessionFactory.getCurrentSession();
		String hql="Select user From User as user where user.poste= :poste";
		Query query= session.createQuery(hql);
		query.setParameter("poste", poste);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public long UserCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(user) from User as user where  user.poste= :poste").uniqueResult();
		return count;
	}

}
