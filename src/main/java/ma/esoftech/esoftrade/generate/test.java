package ma.esoftech.esoftrade.generate;

import java.util.ArrayList;
import java.util.List;

import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.model.Role;
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
//
//		 
//		 Role role=new Role();
//		 role.setId(1);
//		 role.setRole("role");
//		 ma.esoftech.esoftrade.model.User user=new ma.esoftech.esoftrade.model.User();
//		 user.setId(3);
//	     user.setLastName("last");
//	     user.setName("last");
//		 role.setCreator(user);
//		 role.setModifier(user);
//		 RoleDTO roleDTO=(RoleDTO)map.map(role,RoleDTO.class);
//		 Role r1=new Role();
//		 r1.setId(1);
//		 Role r2=new Role();
//		 r2.setId(1);
//		 System.out.println("ref r1"+r1);
//		 System.out.println("ref r2"+r2);
//         List<Role>list=new ArrayList<Role>();
//         list.add(r1);
//         //je vaiwx utiliser ta méthode pour te montrer qu'elle n'a aucune influence
//         list.remove(r2);
//         //taille de la liste rada tb9a hiya hiya egale 1
//         System.out.println(list.size());
//		 System.out.println("ref"+roleDTO);
		 //makibrich dir liya autocomplet
		SessionFactory sessionFactory=new Configuration().configure("hibernate2.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		 session.beginTransaction();
		 User  u=new User();
		u.setLogin("logffg");
		u.setPasswd("eee");
		u.setRef("rgr");
		u.setActive(true);
		u.setDeleted(false);
		Long l=(Long)session.save(u);
		u.setId(l);
		u.setRef("fgh");
		 session.getTransaction().commit();
		session.close();
	}
	public static void cascadeCreateExemple(){
		SessionFactory sessionFactory=new Configuration().configure("hibernate3.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.close();
	
	}
	public static void lazyExemple(){
		SessionFactory sessionFactory=new Configuration().configure("hibernate3.cfg.xml").buildSessionFactory();

		Session session=sessionFactory.openSession();

		System.out.println("get devid");
		//Devis devis=(Devis) session.load(Devis.class, new Integer(3));
		Devis devis= null;
		String hql= "select d from Devis as d join fetch  d.devis where d.id=3";
		Query query=session.createQuery(hql);
		devis=(Devis)query.uniqueResult();
		devis.getId();
		System.out.println("get lines");

		session.close();
		List<LigneDevis> lines=devis.getDevis();
		for (LigneDevis ligneDevis : lines) {
			System.out.println("line");
			
		}
	}

}
