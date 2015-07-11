package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.associated.ContactAssociatedDTO;

public class ContactEditor extends PropertyEditorSupport {

	 public void setAsText(String value) {
		   ContactAssociatedDTO product=new ContactAssociatedDTO();
		   if(Long.valueOf(value)>0){
			   product.setId(Long.valueOf(value));
			   setValue(product);
		   }else{
			   setValue(null);
		   }
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((ContactAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }

}
