package ma.esoftech.esoftrade.controller.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;

import ma.esoftech.esoftrade.DTO.associated.PosteAssociatedDTO;
public class PosteEditor extends PropertiesEditor {
	public void setAsText(String value) {
		   PosteAssociatedDTO poste= new PosteAssociatedDTO();
		   if(Long.valueOf(value)>0){
			   poste.setId(Long.valueOf(value));
			   setValue(poste);
		   }else{
			   setValue(null);
		   }
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((PosteAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }

}
