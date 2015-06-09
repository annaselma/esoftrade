package ma.esoftech.esoftrade.controller.editor;
import ma.esoftech.esoftrade.DTO.associated.PosteCatAssociatedDTO;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class PosteCateEditor extends PropertiesEditor{
	 public void setAsText(String value) {
	    	PosteCatAssociatedDTO category= new PosteCatAssociatedDTO();
	    	if(Long.valueOf(value)>0){
	    	category.setId(Long.valueOf(value));
	         setValue(category);
	    	}else{
	    		setValue(null);
	    	}
	      }

	      public String getAsText() {
	        String s = "";
	        if (getValue() != null) {
	           s=String.valueOf(((PosteCatAssociatedDTO)getValue()).getId());
	        }
	        return s;
	      }
}
