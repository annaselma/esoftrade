package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.Company.CompanyType;
import ma.esoftech.esoftrade.model.Contact;

public interface IContactDao {

	public long createContact(Contact contact);
	public void updateContact(Contact contact);
	public void deleteContact(Contact contact);
	public Contact findById(long id);
	public List<Contact> searchContactByCompany(int lenght, int start, String search,Company company);
	public List<Contact> searchContact(int lenght, int start, String search);
	public List<Contact> getList(int start, int length,String sorting,String filter);
	public List<Contact> getListByCompany(int start, int length,String sorting,Company company,String filter);
	public long countList(String filter);
	public long countListByCompany(String filter,Company company);
}
