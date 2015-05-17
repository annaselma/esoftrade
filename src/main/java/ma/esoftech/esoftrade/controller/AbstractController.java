package ma.esoftech.esoftrade.controller;

import java.util.Date;

import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;
import ma.esoftech.esoftrade.controller.editor.CategoryProductEditor;
import ma.esoftech.esoftrade.controller.editor.DateEditor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
@Controller
public  class AbstractController {

	 public AbstractController() {
		
	}
	@InitBinder
    public void binder(WebDataBinder binder) {
      binder.registerCustomEditor(Date.class, new DateEditor());
      binder.registerCustomEditor(PCategoryAssociatedDTO.class, new CategoryProductEditor());
    }
}
