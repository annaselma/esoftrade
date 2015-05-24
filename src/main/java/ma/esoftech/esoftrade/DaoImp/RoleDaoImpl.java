package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import ma.esoftech.esoftrade.Dao.IRoleDao;
import ma.esoftech.esoftrade.model.Role;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long createRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
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

}
