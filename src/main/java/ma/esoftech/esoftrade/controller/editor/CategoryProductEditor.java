package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;

public class CategoryProductEditor  extends PropertyEditorSupport {
    public void setAsText(String value) {
    	PCategoryAssociatedDTO category=new PCategoryAssociatedDTO();
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
           s=String.valueOf(((PCategoryAssociatedDTO)getValue()).getId());
        }
        return s;
      }

}
