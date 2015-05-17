package ma.esoftech.esoftrade.DaoImp;

import ma.esoftech.esoftrade.Dao.IFileDao;
import ma.esoftech.esoftrade.model.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDao implements IFileDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	public long createFile(File file) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(file);
		return idReturned;
	}

	@Override
	public void updateFile(File file) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(file);
		
	}

	@Override
	public void deleteFile(File file) {
				session= sessionFactory.getCurrentSession();
				session.delete(file);
		
	}

	@Override
	public File findFileById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select file From File as file where file.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		File file= (File)query.uniqueResult();
			return file;
	}

}
