package ma.esoftech.esoftrade.generate;

import java.util.ArrayList;
import java.util.List;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.model.User;

import org.dozer.DozerBeanMapper;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 DozerBeanMapper map = new DozerBeanMapper();
//		 List myMappingFiles= new ArrayList<>();
//		 myMappingFiles.add("dozerMapping.xml");
//		 map.setMappingFiles(myMappingFiles);
//		 ma.esoftech.esoftrade.model.User
//		  u= new ma.esoftech.esoftrade.model.User();
//		 u.setId(3);
//		 u.getEmails().add("del");
//		UserDTO dto=(UserDTO) map.map(u, UserDTO.class);
//
//		System.out.println(dto.getId());
//		System.out.println(dto.getEmail().size());
//		SessionFactory sessionFactory=new Configuration().configure("hibernate2.cfg.xml").buildSessionFactory();
//		Session session=sessionFactory.openSession();
//		session.get(ma.esoftech.esoftrade.model.User.class, new Long(0));
//		session.close();
	//	lazyExemple();
		cascadeCreateExemple();
	}
	public static void cascadeCreateExemple(){
		SessionFactory sessionFactory=new Configuration().configure("hibernate2.cfg.xml").buildSessionFactory();
	
		Session session=sessionFactory.openSession();

		session.close();
	
	}
	public static void lazyExemple(){
		SessionFactory sessionFactory=new Configuration().configure("hibernate2.cfg.xml").buildSessionFactory();

		Session session=sessionFactory.openSession();

		System.out.println("get devid");
		//Devis devis=(Devis) session.load(Devis.class, new Integer(3));
		Devis devis= null;
		String hql= "select u from User as u left  join fetch  u.roles Where 1=1 and u.id=:id";
		Query query=session.createQuery(hql);
		query.setParameter("id", new Long(1));
		 User u=(User)query.uniqueResult();
		 u.getEmails().add("email");
		 session.beginTransaction();
		 session.update(u);
		 session.getTransaction().commit();
		System.out.println("lignes "+query.list().size());
		session.close();

	}

}
