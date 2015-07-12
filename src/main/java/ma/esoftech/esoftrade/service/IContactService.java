package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.DTO.ContactDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.ContactNotFoundException;

public interface IContactService {
	public long createContact(ContactDTO contact,UserDTO creator);
	public void updateContact(ContactDTO contact,UserDTO modifier) throws ContactNotFoundException;
	public void deleteContact(ContactDTO contact) throws ContactNotFoundException;
	public ContactDTO findById(long id) throws ContactNotFoundException;
	public List<ContactDTO> searchContactByCompany(int lenght, int start, String search,CompanyDTO company);
	public List<ContactDTO> searchContact(int lenght, int start, String search);
	public List<ContactDTO> getList(int start, int length,String sorting,String filter);
	public List<ContactDTO> getListByCompany(int start, int length,String sorting,CompanyDTO company,String filter);
	public long countList(String filter);
	public long countListByCompany(String filter,CompanyDTO company);

}
