package ma.esoftech.esoftrade.service;

import java.util.List;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.exception.CompanyNotFoundException;

public interface ICompanyService {

	public long createCompany(CompanyDTO company, UserDTO creator);
	public void updateCompany(CompanyDTO company, UserDTO modifier)throws CompanyNotFoundException;
	public void deleteCompany(CompanyDTO company);
	public CompanyDTO findById(Long id) throws CompanyNotFoundException ;
	public List<CompanyDTO> getSuppliers(int start, int length,String sorting, String filter);
	public List<CompanyDTO> getCustomers(int start, int length,String sorting, String filter);
	public List<CompanyDTO> getCompanies(int start, int length,String sorting, String filter);
	public long companiesCount(String filter);
	public long suppliersCount(String filter);
	public long customersCount(String filter);
	public List<CompanyDTO> searchCustomer(int lenght, int start, String search);
	public List<CompanyDTO> searchSupplier(int lenght, int start, String search);
	public List<CompanyDTO> searchCompany(int lenght, int start, String search);
	public void updatePicture(FileDTO picture,long id,UserDTO modifier) throws CompanyNotFoundException;	
	public void attachFileToCompany(FileDTO fileDTO,long id,UserDTO modifier) throws CompanyNotFoundException;
	public void dettachFileFromCompany(FileDTO fileDTO,long id,UserDTO modifier)throws CompanyNotFoundException;

}
