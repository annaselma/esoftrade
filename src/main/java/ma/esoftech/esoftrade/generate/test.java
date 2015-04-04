package ma.esoftech.esoftrade.generate;

import java.util.Iterator;
import java.util.List;

import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SessionFactory sessionFactory=new Configuration().configure("hibernate2.cfg.xml").buildSessionFactory();

Session session=sessionFactory.openSession();



//Transaction tr=session.beginTransaction();
Role role =(Role) session.load(Role.class, new Long(10));
System.out.println(role.getRole());
List<Permission> list=role.getPermissions();

for (Permission permission : list) {
	System.out.println(permission.getLabel());
}

session.close();
	}

}
