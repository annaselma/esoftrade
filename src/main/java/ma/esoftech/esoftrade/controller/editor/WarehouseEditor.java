package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;

public class WarehouseEditor extends PropertyEditorSupport{
	  public void setAsText(String value) {
		  System.out.println("zz"+value);
		   WarehouseAssociatedDTO warehouse=new WarehouseAssociatedDTO();
		   if(Long.valueOf(value)>0){
		   warehouse.setId(Long.valueOf(value));
		   setValue(warehouse);
		   }else{
			   setValue(null);
		   }
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((WarehouseAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }

}
