package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IMouvementDao;
import ma.esoftech.esoftrade.model.Mouvement;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductWarehouse;
import ma.esoftech.esoftrade.model.Warehouse;
@Repository
public class MouvementDao implements IMouvementDao {
@Autowired
SessionFactory sessionFactory;
Session session;

public MouvementDao() {
}
	@Override
	public Mouvement FindByID(long id) {
		session=sessionFactory.getCurrentSession();
		String hql="From Mouvement as mouvement where mouvement.id=:id ";
		Query query= session.createQuery(hql);
		query.setLong("id", id);
		Mouvement mouvement= (Mouvement)query.uniqueResult();
		return mouvement;
	}

	@Override
	public long createMouvement(Mouvement mouvement) {
		session=sessionFactory.getCurrentSession();
		Long idreturned= (Long)session.save(mouvement);
		return idreturned;
	}

	@Override
	public List<Mouvement> getListMouvement(int start, int length,
			String sorting, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From Mouvement as mouv order by mouv."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Mouvement>mouvement=query.list();
		return mouvement;
	}

	@Override
	public long MouvementCount(String filter) {
		session=sessionFactory.getCurrentSession();
		long count=(Long)session.createQuery("Select count(mouvement) From Mouvement as mouvement ").uniqueResult();
	return count;
	}
	@Override
	public List<Mouvement> getListMouvementByWarehouse(int start, int length,
			String sorting, String filter, Warehouse warehouse) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="select mouv From Mouvement as mouv where mouv.warehouse=:warehouse order by mouv."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setParameter("warehouse",warehouse);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Mouvement>mouvement=query.list();
		return mouvement;
	}
	@Override
	public long MouvementCountByWarehouse(String filter, Warehouse warehouse) {
		session=sessionFactory.getCurrentSession();
		long count=(long)session.
				createQuery("Select count(mouvement) From Mouvement as mouvement where mouvement.warehouse=:warehouse")
				.setParameter("warehouse", warehouse).uniqueResult();
	    return count;
	}
	@Override
	public List<ProductWarehouse> ListProductByWarehouse(int start, int length,
			String sorting, String filter, Warehouse warehouse) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
		String hql="select new ma.esoftech.esoftrade.model.ProductWarehouse(mouvement.product,SUM(mouvement.quantity)) From Mouvement as mouvement "
				+ "where mouvement.warehouse = :warehouse GROUP BY mouvement.product order by mouvement."+sorting;
		Query query= session.createQuery(hql);
		query.setParameter("warehouse", warehouse);
		query.setFirstResult(start).setMaxResults(length);
	
		return(List<ProductWarehouse>) query.list();
	}
	@Override
	public long ProductCountByWarehouse(String filter, Warehouse warehouse) { 
		session=sessionFactory.getCurrentSession();
		String hql="Select count(distinct mouvement.product) From Mouvement as mouvement "
				+ "where mouvement.warehouse=:warehouse  ";
				Query query =session.createQuery(hql);
				query.setParameter("warehouse", warehouse);
				Long count=(Long)query.uniqueResult();
	    return count;
	}
	@Override
	public List<ProductWarehouse> getListWarehouseByProduct(int start,
			int length, String sorting, String filter, Product product) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
		String hql="select "
				+ "new ma.esoftech.esoftrade.model."
				+ "ProductWarehouse(mouvement.warehouse,SUM(mouvement.quantity) as QTE) From Mouvement as mouvement "
				+ "where mouvement.product = :product  GROUP BY mouvement.warehouse  having SUM(mouvement.quantity)>0 order by mouvement."+sorting;
		Query query= session.createQuery(hql);
		query.setParameter("product", product);
		query.setFirstResult(start).setMaxResults(length);
	
		return(List<ProductWarehouse>) query.list();
	}
	@Override
	public long WarehouseCountByProduct(String filter, Product product) {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(distinct mouvement.warehouse) From Mouvement as mouvement  "
				+ "where mouvement.product=:product GROUP BY mouvement.warehouse having SUM(mouvement.quantity)>0 ";
				Query query =session.createQuery(hql);
				query.setParameter("product", product);
				Long count=(Long)query.uniqueResult();
	    return count;
	}
	
	
	

}
