package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.List;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.DTO.ContactDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.IContactDao;
import ma.esoftech.esoftrade.exception.ContactNotFoundException;
import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.Contact;
import ma.esoftech.esoftrade.service.IContactService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements IContactService{
	@Autowired
	private Mapper mapper;
	@Autowired
    private IContactDao contactDao;
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createContact(ContactDTO contact, UserDTO creator) {
	  Contact contactEntity=mapper.map(contact, Contact.class);
	  ServiceUtils.buildEntityModel(creator, contactEntity);
	    contactEntity.setRef(ServiceUtils.TMP_REF);
		Long id=contactDao.createContact(contactEntity);
		contactEntity.setId(id);
		contactEntity.generateGlobalRef();
		contactDao.updateContact(contactEntity);
		return id;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateContact(ContactDTO contact, UserDTO modifier)
			throws ContactNotFoundException {
		Contact contactEntity=mapper.map(contact,Contact.class);
		Contact contactTmp=contactDao.findById(contact.getId());
		if(contactTmp==null){
			throw new ContactNotFoundException(contact.getId());
		}
		contactEntity.setRef(contactTmp.getRef());
		contactEntity.setCreator(contactTmp.getCreator());
		contactEntity.setCreateDate(contactTmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, contactEntity);
	    contactEntity.setDeleted(false);
	    contactEntity.setLastEdit(new Date());
	    contactDao.updateContact(contactEntity);
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteContact(ContactDTO contact)
			throws ContactNotFoundException {
		Contact contactEntity =new Contact();
		contactEntity.setId(contact.getId());
		if(contactDao.findById(contact.getId())==null){
			throw new ContactNotFoundException(contact.getId());
		}
		contactDao.deleteContact(contactEntity);
		
	}
	@Override
	@Transactional(readOnly=true)
	public ContactDTO findById(long id) throws ContactNotFoundException {
		Contact contact=contactDao.findById(id);
		if(contact==null){
			throw new ContactNotFoundException(id);
		}
		
		return mapper.map(contact, ContactDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ContactDTO> searchContactByCompany(int lenght, int start,
			String search, CompanyDTO company) {
		Company companyEntity=new Company();
		companyEntity.setId(company.getId());
		List<Contact> contacts=contactDao.searchContactByCompany(lenght, start, search, companyEntity);
		return DozerHelper.map(mapper, contacts, ContactDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ContactDTO> searchContact(int lenght, int start, String search) {
		List<Contact> contacts=contactDao.searchContact(lenght, start, search);
		return DozerHelper.map(mapper, contacts, ContactDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ContactDTO> getList(int start, int length, String sorting,
			String filter) {
		List<Contact> contacts=contactDao.getList(start, length, sorting, filter);
		return DozerHelper.map(mapper, contacts, ContactDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ContactDTO> getListByCompany(int start, int length,
			String sorting, CompanyDTO company, String filter) {
		Company companyEntity=new Company();
		companyEntity.setId(company.getId());
		List<Contact> contacts=contactDao.getListByCompany(start, length, sorting,companyEntity, filter);
		return DozerHelper.map(mapper, contacts, ContactDTO.class);
	}
	@Override
	@Transactional(readOnly=true)
	public long countList(String filter) {
		return contactDao.countList(filter);
	}
	@Override
	@Transactional(readOnly=true)
	public long countListByCompany(String filter, CompanyDTO company) {
		Company companyEntity=new Company();
		companyEntity.setId(company.getId());
		return contactDao.countListByCompany(filter, companyEntity);
	}
}
