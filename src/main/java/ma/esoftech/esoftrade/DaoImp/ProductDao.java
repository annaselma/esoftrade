package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IProductDao;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.User;

@Repository
public class ProductDao  implements IProductDao{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public Product findById(long id) {
		// TODO Auto-generated method stub
	session= sessionFactory.getCurrentSession();	
	String hql=" From Product as prod left join fetch prod.category where prod.id=: id";
	org.hibernate.Query query= null;
	query= session.createQuery(hql);
	query.setLong("id", id);
	Product product= (Product)query.uniqueResult();
	
		return product;
	}

	@Override
	public Product findByRef(String ref) {
		// TODO Auto-generated method stub
		session= sessionFactory.getCurrentSession();	
		String hql=" From Product as prod left join fetch prod.category where prod.ref=: ref";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setString("ref", ref);
		Product product= (Product)query.uniqueResult();
		
			return product;
	}

	@Override
	public List<Product> getAllProducts(int start, int length, String sorting,
			String filter) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From Product as product order by product."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Product>product=query.list();
		return product;
	}

	@Override
	public long createProduct(Product produit) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(produit);
		return idReturned;
	}

	@Override
	public void updateProduct(Product produit) {
		// TODO Auto-generated method stub
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(produit);
	}

	@Override
	public void deleteProduct(Product produit) {
		// TODO Auto-generated method stub
		session= sessionFactory.getCurrentSession();
		session.delete(produit);
	}

	@Override
	public long ProductCount(String filter) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(Product) from Product as product").uniqueResult();
		return count;
	}
	
	public ProductDao(){
		
	}

}
