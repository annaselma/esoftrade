package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import ma.esoftech.esoftrade.Dao.ICompanyDao;
import ma.esoftech.esoftrade.model.Company;
import ma.esoftech.esoftrade.model.Company.CompanyType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImp  implements ICompanyDao{
	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public long createCompany(Company company) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(company);
		return idReturned;
	}
	@Override
	public void updateCompany(Company company) {
		session=sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(company);
		
	}
	@Override
	public void deleteCompany(Company company) {
		session= sessionFactory.getCurrentSession();
		session.delete(company);
		
	}
	@Override
	public Company findById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select  company From Company as company where company.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		return (Company)query.uniqueResult();
	}
	@Override
	public List<Company> getCompanies(int start, int length, String sorting,
			CompanyType  type, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
		String hql=null;
		switch (type) {
		case supplier:
			  hql="select  company From Company as company   where company.customer=true order by gamme."+sorting;
			break;
       case customer:
    	   hql="select  company From Company as company   where company.supplier=true order by gamme."+sorting;
			break;
	   default:
		   hql="select  company From Company as company   order by gamme."+sorting;
		   break;

		}
	     
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<Company>list=query.list();
	     return list;
	}
	@Override
	public long countCompanies(CompanyType type, String filter) {
		session=sessionFactory.getCurrentSession();
		String hql=null;
		 switch (type) {
			case customer:
				  hql="select  count(company) From Company as company   where company.customer=true ";
				break;
	       case supplier:
	    	   hql="select  count(company) From Company as company   where company.supplier=true ";
				break;
		   default:
			   hql="select  count(company) From Company as company ";
			   break;

			}
		 org.hibernate.Query query=session.createQuery(hql);
		return (long)query.uniqueResult();
	}
	@Override
	public List<Company> searchCompanies(int lenght, int start, String search,
			CompanyType type) {
		session=sessionFactory.getCurrentSession();
		
		String hql=null;
		 switch (type) {
			case supplier:
				hql="select company From Company as company where company.supplier=true and company.name like :search";
				break;
	       case customer:
	    	   hql="select company From Company as company where company.customer=true and   company.name like :search";
				break;
		   default:
			   hql="select company From Company as company where  company.name like :search";
			   break;
			}
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
	}
	
}
