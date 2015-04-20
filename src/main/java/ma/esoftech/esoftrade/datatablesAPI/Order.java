package ma.esoftech.esoftrade.datatablesAPI;

import java.util.List;
import java.util.Map;

import ma.esoftech.esoftrade.datatablesAPI.RequestTable.ColumnCriterias;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.OrderCriterias;

public class Order {
	
	private String name;
	private String orderBy;
	
    public Order(){
    	setName("");
    	setOrderBy("");
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String toString(){
		return getName()+" "+getOrderBy();
	}
	
	public static Order createOrderFromRequestTable(RequestTable request){
		List<Map<OrderCriterias, String>> orders= request.getOrder();
		int column=0;
		String dir=null;
		Order order=new Order();
		for (Map<OrderCriterias, String> orderMap : orders) {
			column= Integer.valueOf(orderMap.get(OrderCriterias.column));
			dir=orderMap.get(OrderCriterias.dir);
			break;
		}
		if(dir!=null){
			order.setOrderBy(dir);
			order.setName(getColumnName(request, column));
			
		}
		return order;
	}
	
	private static String getColumnName(RequestTable request,int index){
	Map<ColumnCriterias, String> column=	request.getColumns().get(index);
	return column.get(ColumnCriterias.name);
	}
}
