package ma.esoftech.esoftrade.DaoImp;

import java.util.Iterator;
import java.util.List;

import ma.esoftech.esoftrade.Dao.IUserDao;
import ma.esoftech.esoftrade.datatablesAPI.FilterCriterias;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	SessionFactory sessionFactory;
	Session session;

	@Override
	public User findByName(String login) {
		// TODO Auto-generated method stub
		String hql= " select u From User u where u.login= :login";
		session= sessionFactory.getCurrentSession();
		Query query = null;
		query= session.createQuery(hql);
		query.setParameter("login", login);
		List list = query.list();
		Iterator it =list.iterator();
		    
		     if(it.hasNext()){
		    	 User user=(User)it.next();
		    	 return user; 
		     }else
		    	 return null; 
	}

	@Override
	public User findById(long id) {
		// TODO verifier fetch pour role et doit générer les autres méthodes
		String sql = " select user From User as user left join fetch  user.roles where user.id= :id";
		session = sessionFactory.getCurrentSession();

		Query query = null;
		query = session.createQuery(sql);

		query.setLong("id", id);

		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public User findByRef(String ref) {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("From User as user  left join fetch user.roles where user.ref= :ref");
		query.setString("ref", ref);
		User user = (User) query.uniqueResult();
		return user;
	}

	@Override
	public List<User> getAllUsers(int start, int length, String sorting,
			String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="select user from User as user order by user."+sorting;
	     Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<User> users=query.list();
		return users;
		
	}

	@Override
	public List<Role> getRolesByUser(User user) {
		// TODO Auto-generated method stub
		session= sessionFactory.getCurrentSession();
		Query query= session.createQuery("select role from User as user inner join user.roles as role where user=:user");
		query.setParameter("user", user);
		List<Role> roles= query.list();
		return roles;
	}

	@Override
	public Long createUser(User user) {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		Long idReturn=(Long)session.save(user);
		return idReturn;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		session = sessionFactory.getCurrentSession();
		session.delete(user);
	}

	@Override
	public long userCount(String filter) {
		// TODO Auto-generated method stub

		session = sessionFactory.getCurrentSession();

		long count = (long) session.createQuery(
				" select count(user) from User as user").uniqueResult();
		return count;

	}

	public UserDao() {
	}

	@Override
	public List<User> getAllUsers(int start, int length, Order sorting,
			FilterCriterias filters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long userCount(FilterCriterias filters) {
		// TODO Auto-generated method stub
		return 0;
	}

}
