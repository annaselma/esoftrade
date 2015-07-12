package ma.esoftech.esoftrade.DaoImp;

import java.util.List;

import ma.esoftech.esoftrade.Dao.IOrderDao;
import ma.esoftech.esoftrade.model.OrderDocument;
import ma.esoftech.esoftrade.model.OrderDocument.OrderType;
import ma.esoftech.esoftrade.model.OrderLine;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImp  implements IOrderDao{

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	@Override
	public long createOrder(OrderDocument order) {
		session=sessionFactory.getCurrentSession();
		Long idReturned=(Long)session.save(order);
				return idReturned;
	}

	@Override
	public void updateOrder(OrderDocument order) {
		session=sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(order);
		
	}

	@Override
	public void deleteOrder(OrderDocument order) {
		session= sessionFactory.getCurrentSession();
		session.delete(order);
		
	}

	@Override
	public OrderDocument findById(long id) {
		session= sessionFactory.getCurrentSession();	
		String hql=" select  ordr From OrderDocument as ordr where ordr.id= :id";
		org.hibernate.Query query= null;
		query= session.createQuery(hql);
		query.setLong("id", id);
		return (OrderDocument)query.uniqueResult();
	}

	@Override
	public List<OrderDocument> getOrders(int start, int length, String sorting,
			OrderType type, String filter) {
		session=sessionFactory.getCurrentSession();
		if(sorting ==null ||sorting.equals("")){
			sorting ="id ASC";
		}
		String hql=null;
		switch (type) {
		case customerOrder:
			  hql="select  ordr From OrderDocument as ordr   where ordr.type='customerOrder' order by ordr."+sorting;
			break;
       case supplierOrder:
    	   hql="select  ordr From OrderDocument as ordr   where ordr.type='supplierOrder' order by ordr."+sorting;
			break;
	   default:
		   hql="select  ordr From OrderDocument as ordr   order by ordr."+sorting;
		   break;

		}
	     
	     org.hibernate.Query query=session.createQuery(hql);
	     query.setFirstResult(start).setMaxResults(length);
	     List<OrderDocument>list=query.list();
	     return list;
	}

	@Override
	public long countOrders(OrderType type, String filter) {
		session=sessionFactory.getCurrentSession();
		String hql=null;
		 switch (type) {
			case customerOrder:
				  hql="select  count(ordr)  From OrderDocument as ordr   where ordr.type='supplierOrder' ";
				break;
	       case supplierOrder:
	    	   hql="select  count(ordr)  From OrderDocument as ordr   where ordr.type='supplierOrder' ";
				break;
		   default:
			   hql="select  count(ordr)  From OrderDocument as ordr";
			   break;

			}
		 org.hibernate.Query query=session.createQuery(hql);
		return (long)query.uniqueResult();

	}

	@Override
	public List<OrderDocument> searchOrders(int lenght, int start, String search,
			OrderType type) {
    session=sessionFactory.getCurrentSession();
		
		String hql=null;
		 switch (type) {
			case supplierOrder:
				hql="select ordr  From OrderDocument as ordr   where ordr.type='customerOrder' and ordr.ref like :search";
				break;
	       case customerOrder:
	    	   hql="select ordr  From OrderDocument as ordr   where ordr.type='supplierOrder' and   ordr.ref like :search";
				break;
		   default:
			   hql="select ordr From  OrderDocument as ordr where  ordr.ref like :search";
			   break;
			}
		org.hibernate.Query query=session.createQuery(hql);
		query.setString("search", "%"+search+"%");
		query.setFirstResult(start).setMaxResults(lenght);
		return query.list();
		}

	@Override
	public long createOrderLine(OrderLine orderLine) {
		session=sessionFactory.getCurrentSession();
		return  (Long)session.save(orderLine);
	}
	
	@Override
	public void updateOrderLine(OrderLine orderLine) {
		session=sessionFactory.getCurrentSession();
		session.flush();
		session.clear();
		session.update(orderLine);
	}

}
