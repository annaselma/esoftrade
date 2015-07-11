package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.associated.CompanyAssociatedDTO;

public class CompanyEditor extends PropertyEditorSupport {

	 public void setAsText(String value) {
		   CompanyAssociatedDTO product=new  CompanyAssociatedDTO();
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
	           s=String.valueOf((( CompanyAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }

}