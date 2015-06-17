package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.PermissionDTO;

public class PermissionEditor extends PropertyEditorSupport{

	public void setAsText(String value) {
    	PermissionDTO permission=new PermissionDTO();
    	if(Long.valueOf(value)>0){
    	permission.setId(Long.valueOf(value));
    	setValue( permission);
    	}else
    		
    		setValue(null);
      }

	  public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((PermissionDTO)getValue()).getId());
	        }
	        return s;
	      }
}
