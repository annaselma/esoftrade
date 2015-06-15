package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IPosteCategoryDao;
import ma.esoftech.esoftrade.model.CategoryPoste;
import ma.esoftech.esoftrade.model.Poste;
@Repository
public class PosteCatDao implements IPosteCategoryDao {
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public CategoryPoste findById(long id) {
		session= sessionFactory.getCurrentSession();
		String hql="From CategoryPoste as category where category.id = :id";
		Query query= session.createQuery(hql);
		query.setLong("id", id);
		CategoryPoste category= (CategoryPoste)query.uniqueResult();
		return category;
	}

	@Override
	public CategoryPoste findByname(String name) {
		session= sessionFactory.getCurrentSession();
		String hql="From CategoryPoste as category where category.name = :name";
		Query query= session.createQuery(hql);
		query.setString("name", name);
		CategoryPoste category= (CategoryPoste)query.uniqueResult();
		return category;
	}

	@Override
	public List<CategoryPoste> getListCategory(int start, int length,
			String sorting, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From CategoryPoste as category order by category."+sorting;
	     Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<CategoryPoste>category=query.list();
		return category;
	}

	@Override
	public List<CategoryPoste> getListCategory(int start, int length) {
		session= sessionFactory.getCurrentSession();
		String hql="From CategoryPoste as category";
		Query query= session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(length);
		return query.list();
	}

	@Override
	public long createCategory(CategoryPoste category) {
		session= sessionFactory.getCurrentSession();
		long idreturned=(long)session.save(category);
		return idreturned;
	}

	@Override
	public void updateCategory(CategoryPoste category) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(category);
		
	}

	@Override
	public void deleteCategory(CategoryPoste category) {
		session= sessionFactory.getCurrentSession();
		session.delete(category);
		
	}

	@Override
	public long categoryCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(CategoryPoste) from CategoryPoste as category").uniqueResult();
		return count;
	}

	@Override
	public List<Poste> getListPosteBycategory(int lenght, int start,
			String sorting, String filter, CategoryPoste category) {
		session= sessionFactory.getCurrentSession();
		String hql="Select poste From Poste as poste where poste.category= :category";
		Query query= session.createQuery(hql);
		query.setParameter("category", category);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public List<CategoryPoste> searchPosteCategories(int lenght, int start,
			String search) {
		session=sessionFactory.getCurrentSession();
		String hql="select category From CategoryPoste as category where category.name like :search";
		Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public long posteCountBycategory(String filter, CategoryPoste category) {
		session=sessionFactory.getCurrentSession();
		String hql=" Select count(Poste) from Poste as poste where poste.category= :category";
		Query query= session.createQuery(hql);
		query.setParameter("category", category);
		Long count= (Long)query.uniqueResult();
		return count;
	}

}
