package ma.esoftech.esoftrade.DaoImp;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IDashboard;
import ma.esoftech.esoftrade.model.Mouvement;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.model.OrderManufacturing.OFStatus;
@Repository
public class DashboardDao  implements IDashboard{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public long getCountOFBlocked( ) {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(orderFab) From OrderManufacturing as orderFab where orderFab.status='blocked' ";
		Query query= session.createQuery(hql);
		long count= (long)query.uniqueResult();
		return count;
	}

	@Override
	public long getCountOFWaiting() {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(orderFab) From OrderManufacturing as orderFab where orderFab.status='waiting'";
		Query query= session.createQuery(hql);
		long count= (long)query.uniqueResult();
		return count;
	}

	@Override
	public long getCountOFProcessing() {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(orderFab) From OrderManufacturing as orderFab where orderFab.status NOT IN('canceled','blocked','end')";
		Query query= session.createQuery(hql);
		long count= (long)query.uniqueResult();
		return count;
	}

	@Override
	public long getCountOFLate(Date currentDate) {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(orderFab) From OrderManufacturing as orderFab where orderFab.endDate< :currentDate and orderFab.status NOT IN('canceled','blocked','end')";
		Query query= session.createQuery(hql);
		query.setParameter("currentDate", currentDate);
		long count= (long)query.uniqueResult();
		return count;
	}

	@Override
	public List<Object[]> ListCriticalOF() {
		// TODO Auto-generated method stub
		return null;
	}

}
