package ma.esoftech.esoftrade.generate;

import java.util.Iterator;
import java.util.List;

import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.Role;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


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
