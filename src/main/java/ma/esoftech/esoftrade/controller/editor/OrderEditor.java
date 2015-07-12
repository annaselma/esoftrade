package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.associated.OrderAssociatedDTO;

public class OrderEditor extends PropertyEditorSupport{

	 public void setAsText(String value) {
		   OrderAssociatedDTO order=new  OrderAssociatedDTO();
		   if(Long.valueOf(value)>0){
			   order.setId(Long.valueOf(value));
			   setValue(order);
		   }else{
			   setValue(null);
		   }
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf((( OrderAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }
}
