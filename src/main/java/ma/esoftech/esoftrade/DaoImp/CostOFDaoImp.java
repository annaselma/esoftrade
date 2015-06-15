package ma.esoftech.esoftrade.DaoImp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.ICostOFDao;
import ma.esoftech.esoftrade.model.OrderManufacturing;
@Repository
public class CostOFDaoImp implements ICostOFDao{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	
	@Override
	public float getCostGOF(OrderManufacturing order) {
		session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("Select SUM(gamme.price*nbposte)FROM Gamme as gamme"
				+"where gamme.order=:order group by gamme.order");
		query.setParameter("order", order);
		float count= (float)query.uniqueResult();
		if (count==0){
			return 0;
		}
		return count;
	}

	@Override
	public float getCostGammeOF(OrderManufacturing order) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
