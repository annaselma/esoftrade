package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.OrderLineDTO;

public class OrderLineEditor extends PropertyEditorSupport  {

	 public void setAsText(String value) {
		   OrderLineDTO orderLine=new   OrderLineDTO();
		   if(Long.valueOf(value)>0){
			   orderLine.setId(Long.valueOf(value));
			   setValue(orderLine);
		   }else{
			   setValue(null);
		   }
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf((( OrderLineDTO)getValue()).getId());
	        }
	        return s;
	      }
}
