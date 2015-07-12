package ma.esoftech.esoftrade.DTO;

import java.util.ArrayList;
import java.util.List;

import ma.esoftech.esoftrade.DTO.associated.OrderAssociatedDTO;

public class OrderExpeditionList {
private List<OrderExpedition> expeditions=new ArrayList<OrderExpedition>();
private OrderAssociatedDTO order;
	



	public List<OrderExpedition> getExpeditions() {
	return expeditions;
}




public void setExpeditions(List<OrderExpedition> expeditions) {
	this.expeditions = expeditions;
}




public OrderAssociatedDTO getOrder() {
	return order;
}




public void setOrder(OrderAssociatedDTO order) {
	this.order = order;
}

}
