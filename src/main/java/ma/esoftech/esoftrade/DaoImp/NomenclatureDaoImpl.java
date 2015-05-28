package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import ma.esoftech.esoftrade.Dao.INomenclatureDao;
import ma.esoftech.esoftrade.model.Nomenclature;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductWarehouse;
import ma.esoftech.esoftrade.model.Warehouse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NomenclatureDaoImpl  implements INomenclatureDao{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public long createNomenclature(Nomenclature nomenclature) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(nomenclature);
		return idReturned;
	}

	@Override
	public void updateNomenclature(Nomenclature nomenclature) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(nomenclature);
		
	}

	@Override
	public void deleteNomenclature(Nomenclature nomenclature) {
		session= sessionFactory.getCurrentSession();
		session.delete(nomenclature);
		
	}

	@Override
	public Nomenclature findNomenclatureById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select  nomenclature From Nomenclature as nomenclature where nomenclature.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		return (Nomenclature)query.uniqueResult();
	}

	@Override
	public List<Nomenclature> getNomenclaturesByManufacturing(int start,
			int length, String sorting, String filter,
			OrderManufacturing manufacturing) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="select  nomenclature From OrderManufacturing as manufac  inner join manufac.nomenclatures as nomenclature "
	     		+ " where manufac=:manufacturing order by nomenclature."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setParameter("manufacturing", manufacturing);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Nomenclature>list=query.list();
	     return list;
	}

	@Override
	public long nomenclatureCountByManufacturing(String filter,
			OrderManufacturing manufacturing) {
		session=sessionFactory.getCurrentSession();
		String hql="select  count(nomenclature) From OrderManufacturing as manufac  inner join manufac.nomenclatures as nomenclature "
	     		+ " where manufac=:manufacturing ";
		 org.hibernate.Query query=session.createQuery(hql);
	     query.setParameter("manufacturing", manufacturing);
		return (long)query.uniqueResult();
	}

	
	/*n'ajoute pas cette methode si tu veux creer GammeDao ;) bob */
	@Override
	public long getImportedQte(Product product,Warehouse warehouse) {
		session=sessionFactory.getCurrentSession();
		
		String hql="select "
				+ "SUM(mouvement.quantity)  From Mouvement as mouvement "
				+ "where mouvement.product = :product and mouvement.warehouse= :warehouse  GROUP BY mouvement.product ";
		Query query= session.createQuery(hql);
		query.setParameter("product", product);
		query.setParameter("warehouse", warehouse);
		query.setMaxResults(1);
	
		return(long) query.uniqueResult();
	}
}
