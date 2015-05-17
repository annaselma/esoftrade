package ma.esoftech.esoftrade.DaoImp;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.ICategoryProductDao;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;
@Repository
public class CategoryProductDao implements ICategoryProductDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public List<ProductCategory> getListCategory(int start, int length,
			String sorting, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From ProductCategory as category order by category."+sorting;
	     Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<ProductCategory>category=query.list();
		return category;
		
	}

	@Override
	public List<ProductCategory> getListCategory(int start, int length) {
		session= sessionFactory.getCurrentSession();
		String hql="From ProductCategory as category";
		Query query= session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(length);
		return query.list();
	}
	@Override
	public List<Product> getListProductBycategory(int lenght, int start,
			String sorting, String filter, ProductCategory category) {
		session= sessionFactory.getCurrentSession();
		String hql="Select prod From Product as prod where prod.category= :category";
		Query query= session.createQuery(hql);
		query.setParameter("category", category);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public ProductCategory findById(long id) {
		session= sessionFactory.getCurrentSession();
		String hql="From ProductCategory as category where category.id = :id";
		Query query= session.createQuery(hql);
		query.setLong("id", id);
		ProductCategory category= (ProductCategory)query.uniqueResult();
		return category;
	}

	@Override
	public long createCategory(ProductCategory category) {
		session= sessionFactory.getCurrentSession();
		Long idReturned=(long)session.save(category);
		
		return idReturned;
	}

	@Override
	public void updateCategory(ProductCategory category) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(category);
		
	}

	@Override
	public void deleteCategory(ProductCategory category) {
		session= sessionFactory.getCurrentSession();
		session.delete(category);
		
	}

	@Override
	public ProductCategory findByname(String name) {
		session=sessionFactory.getCurrentSession();
		String hql="From ProductCategory cat where cat.name= :name";
		Query query= session.createQuery(hql);
		query.setParameter("name", name);
		ProductCategory cat=(ProductCategory) query.uniqueResult();
		return cat;
	}

	@Override
	public long categoryCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(ProductCategory) from ProductCategory as category").uniqueResult();
		return count;
	}

	

	@Override
	public long productCountBycategory(String filter, ProductCategory category) {
		session=sessionFactory.getCurrentSession();
		String hql=" Select count(Product) from Product as prod where prod.category= :category";
		Query query= session.createQuery(hql);
		query.setParameter("category", category);
		Long count= (Long)query.uniqueResult();
		return count;
	}

	

}
