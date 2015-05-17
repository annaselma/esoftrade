package ma.esoftech.esoftrade.controller.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ma.esoftech.esoftrade.DTO.associated.RoleAssociated;

public class RoleEditor extends PropertyEditorSupport {
    public void setAsText(String value) {
    	RoleAssociated role=new RoleAssociated();
    	//role.setId();
 setValue(null);
      }

      public String getAsText() {
        String s = "";
        if (getValue() != null) {
           s = new SimpleDateFormat("dd/MM/yyyy").format((Date) getValue());
        }
        return s;
      }

}
