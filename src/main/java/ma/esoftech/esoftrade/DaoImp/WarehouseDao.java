package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IWarehouseDao;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;
import ma.esoftech.esoftrade.model.Warehouse;
@Repository
public class WarehouseDao implements IWarehouseDao{
@Autowired
SessionFactory sessionFactory;
Session session;


	@Override
	public Warehouse findById(long id) {
		session= sessionFactory.getCurrentSession();
		String hql="From Warehouse as warehouse where warehouse.id = :id";
		Query query= session.createQuery(hql);
		query.setLong("id", id);
		Warehouse warehouse= (Warehouse)query.uniqueResult();
		return warehouse;
	}

	@Override
	public Warehouse findByname(String name) {
		session=sessionFactory.getCurrentSession();
		String hql="From Warehouse ware where ware.name= :name";
		Query query= session.createQuery(hql);
		query.setParameter("name", name);
		Warehouse warehouse= (Warehouse)query.uniqueResult();
		return warehouse;
	}

	@Override
	public List<Warehouse> getListWarehouse(int start, int length,
			String sorting, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="select w From Warehouse as w order by w."+sorting;
	     Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Warehouse>warehouse=query.list();
		return warehouse;
	}

	@Override
	public long createWarehouse(Warehouse warehouse) {
		session= sessionFactory.getCurrentSession();
		Long idReturned=(long)session.save(warehouse);
		
		return idReturned;
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(warehouse);
		
	}

	@Override
	public void deleteWarehouse(Warehouse warehouse) {
		session= sessionFactory.getCurrentSession();
		session.delete(warehouse);
	}

	@Override
	public long warehouseCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count= (Long)session.createQuery("Select count(warehouse) From Warehouse as warehouse ").uniqueResult();
		return count;
	}

	@Override
	public List<Product> getListProductByWarehouse(int lenght, int start,
			String sorting, String filter, Warehouse warehouse) {
		session= sessionFactory.getCurrentSession();
		String hql="Select prod From Mouvement  as mouv inner join mouv.product "
				+ "as prod  GROUP BY(prod) where mouv.warehouse= :warehouse";
		Query query= session.createQuery(hql);
		query.setParameter("warehouse", warehouse);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}
	@Override
	public long productCountBywrehouse(String filter, Warehouse warehouse) {
		session=sessionFactory.getCurrentSession();
		String hql=" Select count(prod) from Mouvement as mouv inner join mouv.product as prod  where mouv.warehouse= :warehouse";
		Query query= session.createQuery(hql);
		query.setParameter("warehouse", warehouse);
		Long count= (Long)query.uniqueResult();
		return count;
	}

	@Override
	public List<Warehouse> getListWarehouses(int start, int length) {
		session= sessionFactory.getCurrentSession();
		String hql="From Warehouse as warehouse";
		Query query= session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(length);
		return query.list();
	}
	@Override
	public List<Warehouse> searchWarehouses(int lenght, int start,
			String search) {
		session=sessionFactory.getCurrentSession();
		String hql="select warehouse From Warehouse as warehouse where warehouse.name like :search";
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	

}
