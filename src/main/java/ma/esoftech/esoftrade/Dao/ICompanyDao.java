package ma.esoftech.esoftrade.Dao;

import java.util.List;

import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.Company.CompanyType;

public interface ICompanyDao {
	public long createCompany(Company company);
	public void updateCompany(Company company);
	public void deleteCompany(Company company);
	public Company findById(long id);
    public List<Company> getCompanies(int start, int length,String sorting,CompanyType type,String filter);
    public long countCompanies(CompanyType type,String filter);
    public List<Company> searchCompanies(int lenght, int start, String search,CompanyType type);
}
