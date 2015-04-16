package ma.esoftech.esoftrade.controller;

import java.util.Date;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.UserDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/customer")
public class CustomerContr extends AbstractController {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCustomer( @ModelAttribute("customer") @Valid  UserDTO customer, BindingResult result) {
 System.out.println("naaame "+customer.getName());
 
		if (result.hasErrors()) {
			return "customer";
		} else {
			System.out.println(customer.getCreateDate().toLocaleString());
			return "done";
		}
 
	}
 
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {
 
		model.addAttribute("customer", new UserDTO() );
		return "customer";
 
	}
	
 
}
