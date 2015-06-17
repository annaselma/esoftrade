package ma.esoftech.esoftrade.DaoImp;

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
	public long getCountOFBlocked() {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(order) From OrderManufacturing as order where order.status='blocked' ";
		Query query= session.createQuery(hql);
		long count= (long)query.uniqueResult();
		return count;
	}

	@Override
	public long getCountOFWaiting(OrderManufacturing order) {
		session=sessionFactory.getCurrentSession();
		String hql="Select count(order) From OrderManufacturing as order where order.status=:waiting";
		Query query= session.createQuery(hql);
		query.setParameter("waiting", order.getStatus());
		long count= (long)query.uniqueResult();
		return count;
	}

	@Override
	public long getCountOFProcessing(OrderManufacturing order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCountOFLate(OrderManufacturing order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object[]> ListCriticalOF(OrderManufacturing order) {
		// TODO Auto-generated method stub
		return null;
	}

}
