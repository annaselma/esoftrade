package ma.esoftech.esoftrade.controller;

import java.util.Date;

import ma.esoftech.esoftrade.DTO.OrderLineDTO;
import ma.esoftech.esoftrade.DTO.PermissionDTO;
import ma.esoftech.esoftrade.DTO.associated.CompanyAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.ContactAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.OrderAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.PCategoryAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.PosteAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.PosteCatAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.UserAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;
import ma.esoftech.esoftrade.controller.editor.CategoryProductEditor;
import ma.esoftech.esoftrade.controller.editor.CompanyEditor;
import ma.esoftech.esoftrade.controller.editor.ContactEditor;
import ma.esoftech.esoftrade.controller.editor.DateEditor;
import ma.esoftech.esoftrade.controller.editor.OrderEditor;
import ma.esoftech.esoftrade.controller.editor.OrderLineEditor;
import ma.esoftech.esoftrade.controller.editor.PermissionEditor;
import ma.esoftech.esoftrade.controller.editor.PosteCateEditor;
import ma.esoftech.esoftrade.controller.editor.PosteEditor;
import ma.esoftech.esoftrade.controller.editor.ProductEditor;
import ma.esoftech.esoftrade.controller.editor.UserEditor;
import ma.esoftech.esoftrade.controller.editor.WarehouseEditor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class AbstractController {

	public AbstractController() {

	}

	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(PCategoryAssociatedDTO.class,
				new CategoryProductEditor());
		binder.registerCustomEditor(WarehouseAssociatedDTO.class,
				new WarehouseEditor());
		binder.registerCustomEditor(ProductAssociatedDTO.class,
				new ProductEditor());
		binder.registerCustomEditor(UserAssociatedDTO.class, new UserEditor());
		binder.registerCustomEditor(PermissionDTO.class, new PermissionEditor());
		binder.registerCustomEditor(PosteAssociatedDTO.class, new PosteEditor());
		binder.registerCustomEditor(PosteCatAssociatedDTO.class,
				new PosteCateEditor());
		binder.registerCustomEditor(ContactAssociatedDTO.class,
				new ContactEditor());
		binder.registerCustomEditor(CompanyAssociatedDTO.class,
				new CompanyEditor());
		binder.registerCustomEditor(OrderLineDTO.class,
				new OrderLineEditor());
		binder.registerCustomEditor(OrderAssociatedDTO.class,
				new OrderEditor());
	}

}
