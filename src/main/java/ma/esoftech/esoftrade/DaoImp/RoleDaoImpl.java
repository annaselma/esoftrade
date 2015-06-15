package ma.esoftech.esoftrade.DaoImp;


import java.util.List;

import ma.esoftech.esoftrade.Dao.IRoleDao;
import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.Role;
import ma.esoftech.esoftrade.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements IRoleDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
	@Override
	public Role findById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select rle From Role as rle  where rle.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		Role role= (Role)query.uniqueResult();
			return role;
	}

	@Override
	public long createRole(Role role) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(role);
		return idReturned;
	}

	@Override
	public void updateRole(Role role) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(role);		
	}

	@Override
	public void deleteRole(Role role) {
		session= sessionFactory.getCurrentSession();
		session.delete(role);
	}

	@Override
	public long RoleCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(role) from Role as role").uniqueResult();
		return count;
	}

	@Override
	public List<Role> getRoles(int start, int length, String sorting,
			String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From Role as rle order by rle."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     return query.list();
	}

	@Override
	public List<Role> searchRoles(int lenght, int start, String search) {
		session =sessionFactory.getCurrentSession();
		String hql="select role from Role as role where role.role  like :search";
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public List<Permission> getPermissions(int start, int lenght) {
		session =sessionFactory.getCurrentSession();
		String hql="select perm from Permission as perm ";
		org.hibernate.Query query=session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public List<Permission> searchPermissions(int lenght, int start,
			String search) {
		session =sessionFactory.getCurrentSession();
		String hql="select perm from Permission as perm  where perm.label like :search";
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public List<Role> searchRoleNotIN(int lenght,int start,User id, String search) {
		session =sessionFactory.getCurrentSession();
		String hql="select rle from Role as rle  where rle not in ( select rl2 from User as user inner join user.roles as rl2 where user=:usr) and rle.role like :search";
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setParameter("usr",id);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

}
