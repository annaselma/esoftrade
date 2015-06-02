package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IGammeDao;
import ma.esoftech.esoftrade.model.Gamme;
import ma.esoftech.esoftrade.model.Nomenclature;
import ma.esoftech.esoftrade.model.OrderManufacturing;
@Repository
public class GammeDaoImpl implements IGammeDao{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public long createGamme(Gamme gamme) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(gamme);
		return idReturned;
	}

	@Override
	public void updateGamme(Gamme gamme) {
		session=sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(gamme);
		
	}

	@Override
	public void deleteGamme(Gamme gamme) {
		session= sessionFactory.getCurrentSession();
		session.delete(gamme);
		
	}

	@Override
	public Gamme findGammeById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select  gamme From Gamme as gamme where gamme.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		return (Gamme)query.uniqueResult();
	}

	@Override
	public List<Gamme> getGammeByManufacturing(int start, int length,
			String sorting, String filter, OrderManufacturing manufacturing) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="select  gamme From OrderManufacturing as manufac  inner join manufac.gammes as gamme "
	     		+ " where manufac=:manufacturing order by gamme."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setParameter("manufacturing", manufacturing);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Gamme>list=query.list();
	     return list;
	}

	@Override
	public long GammeCountByManufacturing(String filter,
			OrderManufacturing manufacturing) {
		session=sessionFactory.getCurrentSession();
		String hql="select  count(gamme) From OrderManufacturing as manufac  inner join manufac.gammes as gamme "
	     		+ " where manufac=:manufacturing ";
		 org.hibernate.Query query=session.createQuery(hql);
	     query.setParameter("manufacturing", manufacturing);
		return (long)query.uniqueResult();
	}

}
