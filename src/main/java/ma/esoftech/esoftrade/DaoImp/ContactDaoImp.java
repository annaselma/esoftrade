package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.Dao.IContactDao;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.Company.CompanyType;
import ma.esoftech.esoftrade.model.Contact;
import ma.esoftech.esoftrade.serviceImpl.ContactServiceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class ContactDaoImp implements IContactDao {
	@Autowired
	SessionFactory sessionFactory;
	Session session;

	@Override
	public long createContact(Contact contact) {
		session = sessionFactory.getCurrentSession();
		Long idReturned = (Long) session.save(contact);
		return idReturned;
	}

	@Override
	public void updateContact(Contact contact) {
		session = sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(contact);

	}

	@Override
	public void deleteContact(Contact contact) {
		session = sessionFactory.getCurrentSession();
		session.delete(contact);

	}

	@Override
	public Contact findById(long id) {
		session = sessionFactory.getCurrentSession();
		String hql = " select  contact From Contact as contact where contact.id= :id";
		org.hibernate.Query query = null;
		query = session.createQuery(hql);
		query.setLong("id", id);
		return (Contact) query.uniqueResult();
	}

	@Override
	public List<Contact> searchContactByCompany(int lenght, int start,
			String search, Company company) {
		session = sessionFactory.getCurrentSession();
		String hql = "select contact From Contact as contact where contact.company=:company and (company.name like :search or company.lastName like :search)";
		org.hibernate.Query query = session.createQuery(hql);
		query.setString("search", "%" + search + "%");
		query.setParameter("company", company);
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public List<Contact> searchContact(int lenght, int start, String search) {
		session = sessionFactory.getCurrentSession();
		String hql = "select contact From Contact as contact where company.name like :search or company.lastName like :search";
		org.hibernate.Query query = session.createQuery(hql);
		query.setString("search", "%" + search + "%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}

	@Override
	public List<Contact> getList(int start, int length, String sorting,
			String filter) {
		session = sessionFactory.getCurrentSession();
		if (sorting == null || sorting.equals("")) {
			sorting = "id ASC";
		}
		String hql = "From Contact as contact order by contact." + sorting;
		org.hibernate.Query query = session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(length);
		List<Contact> contacts = query.list();
		return contacts;
	}

	@Override
	public List<Contact> getListByCompany(int start, int length,
			String sorting, Company company, String filter) {
		session = sessionFactory.getCurrentSession();
		if (sorting == null || sorting.equals("")) {
			sorting = "id ASC";
		}
		String hql = "From Contact as contact where contact.company=:company  order by contact."
				+ sorting;
		org.hibernate.Query query = session.createQuery(hql);
		query.setFirstResult(start).setMaxResults(length);
		query.setParameter("company", company);
		List<Contact> contacts = query.list();
		return contacts;
	}

	@Override
	public long countList(String filter) {
		session = sessionFactory.getCurrentSession();
		Long count = (Long) session.createQuery(
				" Select count(contact) from Contact as contact")
				.uniqueResult();
		return count;
	}

	@Override
	public long countListByCompany(String filter, Company company) {
		session = sessionFactory.getCurrentSession();
		Long count = (Long) session
				.createQuery(
						" Select count(contact) from Contact as contact where contact.company=:company")
				.setParameter("company", company).uniqueResult();

		return count;
	}

	
}
