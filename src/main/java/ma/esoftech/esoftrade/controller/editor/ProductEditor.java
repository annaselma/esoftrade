package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;

public class ProductEditor extends PropertyEditorSupport {
	 public void setAsText(String value) {
		   ProductAssociatedDTO product=new ProductAssociatedDTO();
		   product.setId(Long.valueOf(value));
		   setValue(product);
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((ProductAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }


}
