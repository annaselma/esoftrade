package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;

public class ProductEditor extends PropertyEditorSupport {
	 public void setAsText(String value) {
		   ProductAssociatedDTO product=new ProductAssociatedDTO();
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
	           s=String.valueOf(((ProductAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }


}
