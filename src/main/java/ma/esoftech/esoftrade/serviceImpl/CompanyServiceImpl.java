package ma.esoftech.esoftrade.serviceImpl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.Dao.ICompanyDao;
import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.exception.CompanyNotFoundException;
import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.Company.CompanyType;
import ma.esoftech.esoftrade.model.File;
import ma.esoftech.esoftrade.service.ICompanyService;
import ma.esoftech.esoftrade.service.ServiceUtils;
import ma.esoftech.esoftrade.utils.DozerHelper;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	Mapper mapper;
	@Autowired
	ICompanyDao companyDao;
	@Autowired
	IFileDao fileDao;
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public long createCompany(CompanyDTO company, UserDTO creator) {
		Company compayEntity= mapper.map(company, Company.class);
		ServiceUtils.buildEntityModel(creator, compayEntity);
		compayEntity.setRef(ServiceUtils.TMP_REF);
		Long idPicture=fileDao.createFile(createDefaultPicture());
		File picture=new File();
		picture.setId(idPicture);
		compayEntity.setPicture(picture);
		Long idCompany=companyDao.createCompany(compayEntity);
		compayEntity.setId(idCompany);
	     compayEntity.generateReference();
		companyDao.updateCompany(compayEntity);
		return idCompany;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateCompany(CompanyDTO company, UserDTO modifier)
			throws CompanyNotFoundException {
		Company companyEntity= mapper.map(company, Company.class);
	    Company companytmp=companyDao.findById(companyEntity.getId());
	    
	   if(companytmp==null){
		   throw new CompanyNotFoundException(companyEntity.getId());
	   }
	    companyEntity.setRef(companytmp.getRef());
	    companyEntity.setCustomerCode(companytmp.getCustomerCode());
	    companyEntity.setSupplierCode(companytmp.getSupplierCode());
	    companyEntity.setCreator(companytmp.getCreator());
	    companyEntity.setCreateDate(companytmp.getCreateDate());
	    ServiceUtils.EditEntityModel(modifier, companyEntity);
	    companyEntity.setDeleted(false);
	    companyEntity.setLastEdit(new Date());
	    companyEntity.setPicture(companytmp.getPicture());
	    companyEntity.setFiles(companytmp.getFiles());
	    companyDao.updateCompany(companyEntity);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteCompany(CompanyDTO company) {
		Company companyEntity=new Company();
		companyEntity.setId(company.getId());
		companyDao.deleteCompany(companyEntity);
	}

	@Override
	@Transactional(readOnly=true)
	public CompanyDTO findById(Long id) throws CompanyNotFoundException {
		Company company=companyDao.findById(id);
		if(company==null){
			throw new CompanyNotFoundException(id);
		}
		return mapper.map(company, CompanyDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompanyDTO> getSuppliers(int start, int length, String sorting,
			String filter) {
		CompanyType isSupplier=CompanyType.supplier;
		List<Company> suppliers=companyDao.getCompanies(start, length, sorting, isSupplier, filter);
		return DozerHelper.map(mapper, suppliers, CompanyDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompanyDTO> getCustomers(int start, int length, String sorting,
			String filter) {
		CompanyType isCustomer=CompanyType.customer;
		List<Company> customers=companyDao.getCompanies(start, length, sorting, isCustomer, filter);
		return DozerHelper.map(mapper, customers, CompanyDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompanyDTO> getCompanies(int start, int length, String sorting,
			String filter) {
		CompanyType isCompany=CompanyType.all;
		List<Company> companies=companyDao.getCompanies(start, length, sorting, isCompany, filter);
		return DozerHelper.map(mapper, companies, CompanyDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public long companiesCount(String filter) {
		CompanyType isCompany=CompanyType.all;
		return companyDao.countCompanies(isCompany, filter);
	}

	@Override
	@Transactional(readOnly=true)
	public long suppliersCount(String filter) {
		CompanyType isSupplier=CompanyType.supplier;
		return companyDao.countCompanies(isSupplier, filter);
	}

	@Override
	@Transactional(readOnly=true)
	public long customersCount(String filter) {
		CompanyType isCustomer=CompanyType.customer;
		return companyDao.countCompanies(isCustomer, filter);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompanyDTO> searchCustomer(int lenght, int start, String search) {
		CompanyType isCustomer=CompanyType.customer;
		List<Company> customers=companyDao.searchCompanies(lenght, start, search, isCustomer);
		return DozerHelper.map(mapper, customers, CompanyDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompanyDTO> searchSupplier(int lenght, int start, String search) {
		CompanyType isSupplier=CompanyType.supplier;
		List<Company> suppliers=companyDao.searchCompanies(lenght, start, search, isSupplier);
		return DozerHelper.map(mapper, suppliers, CompanyDTO.class);
	}

	@Override
	@Transactional(readOnly=true)
	public List<CompanyDTO> searchCompany(int lenght, int start, String search) {
		CompanyType isCompany=CompanyType.all;
		List<Company> companies=companyDao.searchCompanies(lenght, start, search, isCompany);
		return DozerHelper.map(mapper,companies, CompanyDTO.class);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updatePicture(FileDTO picture, long id, UserDTO modifier)
			throws CompanyNotFoundException {
		Company companyEntity=companyDao.findById(id);
		if(companyEntity==null){
			throw new  CompanyNotFoundException(id);
		}
		 ServiceUtils.EditEntityModel(modifier, companyEntity);
	     File file=new File();
	     file.setId(picture.getId());
	    File ImageToDelete=companyEntity.getPicture();
	    companyEntity.setPicture(file);
	     companyDao.updateCompany(companyEntity);
	     if(ImageToDelete!=null && ImageToDelete.getId()>0)
	            fileDao.deleteFile(ImageToDelete);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void attachFileToCompany(FileDTO fileDTO, long id, UserDTO modifier)
			throws CompanyNotFoundException {
		Company companyEntity=companyDao.findById(id);
	    if(companyEntity==null){
	   	 throw new CompanyNotFoundException(id);
	    }
	    ServiceUtils.EditEntityModel(modifier, companyEntity);
	    File file=new File();
	    file.setId(fileDTO.getId());
	    companyEntity.getFiles().add(file);
	    companyDao.updateCompany(companyEntity);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void dettachFileFromCompany(FileDTO fileDTO, long id,
			UserDTO modifier) throws CompanyNotFoundException {
		Company companyEntity=companyDao.findById(id);
	    if(companyEntity==null){
	   	 throw new CompanyNotFoundException(id);
	    }
	    ServiceUtils.EditEntityModel(modifier, companyEntity);
	    Set<File> files=companyEntity.getFiles();
	    Iterator<File> it=files.iterator();
	    File entity;
	    while(it.hasNext()){
	    	entity=it.next();
	    	if(entity.getId()==fileDTO.getId()){
	    		files.remove(entity);
	    		break;
	    	}
	    }
	    companyDao.updateCompany(companyEntity);
		
	}
	
	
	private File createDefaultPicture(){
		File picture=new File();
		picture.setCreateDate(new Date());
		picture.setDeleted(false);
		picture.setDescription("");
		picture.setLastEdit(new Date());
		picture.setLength(0);
		picture.setMask(000);
		picture.setName(FileUploadUTILS.DEFAULT_PICTURE_USER_NAME);
		picture.setPath(FileUploadUTILS.getPathFile()+"/"+FileUploadUTILS.DEFAULT_PICTURE_USER_NAME);
		picture.setType("png");
		return picture;
	}

}
