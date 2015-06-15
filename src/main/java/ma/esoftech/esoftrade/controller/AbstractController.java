package ma.esoftech.esoftrade.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.esoftech.esoftrade.DTO.PermissionDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.UserAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;
import ma.esoftech.esoftrade.controller.editor.CategoryProductEditor;
import ma.esoftech.esoftrade.controller.editor.DateEditor;
import ma.esoftech.esoftrade.controller.editor.PermissionEditor;
import ma.esoftech.esoftrade.controller.editor.ProductEditor;
import ma.esoftech.esoftrade.controller.editor.UserEditor;
import ma.esoftech.esoftrade.controller.editor.WarehouseEditor;
import ma.esoftech.esoftrade.controller.session.SessionBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
@Controller
public  class AbstractController  {

	 
	 public AbstractController() {
		
	}
	@InitBinder
    public void binder(WebDataBinder binder) {
      binder.registerCustomEditor(Date.class, new DateEditor());
      binder.registerCustomEditor(PCategoryAssociatedDTO.class, new CategoryProductEditor());
      binder.registerCustomEditor(WarehouseAssociatedDTO.class,new WarehouseEditor());
      binder.registerCustomEditor(ProductAssociatedDTO.class,new ProductEditor());
      binder.registerCustomEditor(UserAssociatedDTO.class,new UserEditor());
      binder.registerCustomEditor(PermissionDTO.class, new PermissionEditor());
    }

}
