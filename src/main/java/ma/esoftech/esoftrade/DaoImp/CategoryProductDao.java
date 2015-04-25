package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.ICategoryProductDao;
import ma.esoftech.esoftrade.model.ProductCategory;
@Repository
public class CategoryProductDao implements ICategoryProductDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<ProductCategory> getListCategory(int start, int length,
			String sorting, String filter) {
		
		return null;
	}

	@Override
	public List<ProductCategory> getListCategory(int start, int length) {
		session= sessionFactory.getCurrentSession();
		String hql="From ProductCategory as category";
		Query query= session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(length);
		return query.list();
	}

}
