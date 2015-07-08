package ma.esoftech.esoftrade.generate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import ma.esoftech.esoftrade.model.Permission;
import ma.esoftech.esoftrade.model.User;
import ma.esoftech.esoftrade.model.Permission.Module;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		createPermis();
//		SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			Date date=f.parse("11/11/2017");
//			long days=date.getTime()-new Date().getTime();
//			days=days/1000;
//			days=days/3600;
//			days=days/24;
//			System.out.println("days "+days);
//			
//					
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

	public static void cascadeCreateExemple() {
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate2.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.close();

	}

	public static void createPermis() {
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate2.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
//		generateManufacturingPermissions(session);
//		generateProductPermissions(session);
//		generateRolePermissions(session);
		generatePostePermissions(session);
//		generateWareHousePermissions(session);
		session.getTransaction().commit();
		session.close();

	}

	public static Permission create(String label, String desc) {
		Permission permission = new Permission();
		permission.setDeleted(false);
		permission.setCreator(null);
		permission.setModifier(null);
		permission.setDeleted(false);
		permission.setLabel(label);
		permission.setDescription(desc);
		return permission;

	}

	public static void generateUserPermissions(Session session) {
		Module module = Module.User;
		session.save(create("WRITE_USER", "creer/modifier les utilisateurs",
				module));
		session.save(create("DELETE_USER", "supprimer les utilisateurs", module));
		session.save(create("READ_USER",
				"consulter les profiles des utilisateurs", module));
		session.save(create("EDIT_SELF_USER",
				"modifier ses propres informations utilisateur", module));
		session.save(create("ADD_ROLE_TO_USER",
				"ajouter les roles aux utilisateurs ", module));
		session.save(create("DELETE_ROLE_FROM_USER",
				"enlever les roles aux utilisateurs ", module));
	}

	public static void generateRolePermissions(Session session) {
		Module module = Module.Role;
		session.save(create("WRITE_ROLE", "creer modifier les roles", module));
		session.save(create("DELETE_ROLE", "supprimer les roles", module));
		session.save(create("READ_ROLE", "consulter les  roels", module));

	}

	public static void generateWareHousePermissions(Session session) {
		Module module = Module.WareHouse;
		session.save(create("WRITE_WAREHOUSE", "creer/modifier les entrepots",
				module));
		session.save(create("DELETE_WAREHOUSE", "supprimer les entrepots",
				module));
		session.save(create("READ_WAREHOUSE", "consulter les entrepots", module));
		session.save(create("CORRECT_TRANSFERT_STOCK",
				"corriger et transferer le stock", module));
		session.save(create("ADD_FILE_TO_WAREHOUSE",
				"ajouter les fichiers aux  entrepots ", module));
		session.save(create("DELETE_FILE_FROM_WAREHOUSE",
				"enlever les fichiers aux entrepots ", module));
	}

	public static void generateProductPermissions(Session session) {
		Module module = Module.Product;
		session.save(create("WRITE_PRODUCT", "creer/modifier les produits",
				module));
		session.save(create("DELETE_PRODUCT", "supprimer les produits", module));
		session.save(create("READ_PRODUCT", "consulter les produits", module));
		session.save(create("READ_CATEGORY", "consulter les catégories", module));
		session.save(create("WRITE_CATEGORY", "creer/modifier les catégories",
				module));
		session.save(create("DELETE_CATEGORY", "supprimer les catégories",
				module));
		session.save(create("ADD_FILE_TO_PRODUCT",
				"ajouter les fichiers aux produits ", module));
		session.save(create("DELETE_FILE_FROM_PRODUCT",
				"enlever les fichiers aux produits ", module));
		session.save(create("ADD_PICTURE_TO_PRODUCT",
				"ajouter une photo aux produits ", module));
		
	}

	public static void generateManufacturingPermissions(Session session) {
		Module module = Module.Manufacturing;
		session.save(create(
				"GENERATE_MANUFACTURING",
				"générér les ordres de fabrication à partir des commandes clients",
				module));
		session.save(create("WRITE_MANUFACTURING",
				"creer/modifier les ordres de fabrication ", module));
		session.save(create("DELETE_MANUFACTURING",
				"supprimer les ordres de fabrication ", module));
		session.save(create("READ_MANUFACTURING",
				"consulter les ordres de fabrication ", module));
		session.save(create("ADD_FILE_TO_MANUFACTURING",
				"ajouter les fichiers aux ordres de fabrication  ", module));
		session.save(create("DELETE_FILE_FROM_MANUFACTURING",
				"enlever les fichiers aux ordres de fabrication ", module));
		/** Gamme **/
		session.save(create("ADD_FILE_TO_GAMME",
				"ajouter les fichiers aux gammes ", module));
		session.save(create("DELETE_FILE_FROM_GAMME",
				"enlever les fichiers aux gammes ", module));
		session.save(create("READ_GAMME", "consulter les gammes", module));
		session.save(create("WRITE_GAMME", "creer/modifier les gammes", module));
		session.save(create("DELETE_GAMME", "supprimer les gammes", module));
		/** Nomenclature **/
		session.save(create("READ_NOMENCLATURES",
				"consulter les nomenclatures", module));
		session.save(create("WRITE_NOMENCLATURES",
				"creer/modifier les nomenclatures", module));
		session.save(create("DELETE_NOMENCLATURES",
				"supprimer les nomenclatures", module));
	}
	public static void generatePostePermissions(Session session) {
		Module module = Module.Poste;
		session.save(create("WRITE_POSTE", "creer/modifier les postes",
				module));
		session.save(create("DELETE_POSTE", "supprimer les postes", module));
		session.save(create("READ_POSTE",
				"consulter les profiles des postes", module));
		session.save(create("READ_CATEGORY_POSTE", "consulter les catégories", module));
		session.save(create("WRITE_CATEGORY", "creer/modifier les catégories",
				module));
		session.save(create("DELETE_CATEGORY_POSTE", "supprimer les catégories",
				module));
		session.save(create("ADD_FILE_TO_POSTE",
				"ajouter les docs et fiches de pointage aux postes", module));
		session.save(create("DELETE_FILE_FROM_POSTE",
				"enlever les fichiers aux postes ", module));
	}


	public static Permission create(String label, String desc, Module module) {
		Permission permission = new Permission();
		;
		permission.setDeleted(false);
		permission.setCreator(null);
		permission.setModifier(null);
		permission.setDeleted(false);
		permission.setLabel(label);
		permission.setModule(module);
		permission.setDescription(desc);
		return permission;

	}

	public static void lazyExemple() {
		SessionFactory sessionFactory = new Configuration().configure(
				"hibernate2.cfg.xml").buildSessionFactory();

		Session session = sessionFactory.openSession();

		System.out.println("get devid");
		// Devis devis=(Devis) session.load(Devis.class, new Integer(3));
		Devis devis = null;
		String hql = "select u from User as u left  join fetch  u.roles Where 1=1 and u.id=:id";
		Query query = session.createQuery(hql);
		Object id = new Long(1);
		query.setParameter("id", id);
		User u = (User) query.uniqueResult();
		session.beginTransaction();
		// session.update(u);
		session.getTransaction().commit();
		System.out.println("lignes " + query.list().size());
		session.close();

	}

}
