package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.esoftech.esoftrade.Dao.IManufacturinOrder;
import ma.esoftech.esoftrade.model.OrderManufacturing;
@Repository
public class ManufacturingOrderDao implements IManufacturinOrder{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public OrderManufacturing findById(long id) {
		session=sessionFactory.getCurrentSession();
		String hql="From OrderManufacturing as fabrication where fabrication.id=:id ";
		Query query= session.createQuery(hql);
		query.setLong("id", id);
		OrderManufacturing OF=(OrderManufacturing) query.uniqueResult();
		return OF;
	}

	@Override
	public OrderManufacturing findByRef(String ref) {
		session= sessionFactory.getCurrentSession();	
		String hql=" From OrderManufacturing as fabrication  where fabrication.ref=: ref";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setString("ref", ref);
		OrderManufacturing OF= (OrderManufacturing)query.uniqueResult();
		return OF;
	}

	@Override
	public List<OrderManufacturing> getAllOF(int start, int length,
			String sorting, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
	     String hql="From OrderManufacturing as fabrication order by fabrication."+sorting;
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<OrderManufacturing>orderManu= query.list();
		return orderManu;
	}

	@Override
	public long createOF(OrderManufacturing OFabrication) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(OFabrication);
		return idReturned;
	}

	@Override
	public void updateOF(OrderManufacturing OFabrication) {
		session= sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(OFabrication);
	}

	@Override
	public void deleteOF(OrderManufacturing OFabrication) {
		session=sessionFactory.getCurrentSession();
		session.delete(OFabrication);
		
	}

	@Override
	public long ManufacturingCount(String filter) {
		session=sessionFactory.getCurrentSession();
		Long count=(Long)session.createQuery(" Select count(OFabrication) from OrderManufacturing as OFabrication").uniqueResult();
		return count;
	}
	}


