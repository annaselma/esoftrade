package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;

import ma.esoftech.esoftrade.DTO.associated.UserAssociatedDTO;

public class UserEditor extends PropertyEditorSupport{
	public void setAsText(String value) {
		  UserAssociatedDTO user= new UserAssociatedDTO();
		   user.setId(Long.valueOf(value));
		   setValue(user);
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((UserAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }
}
