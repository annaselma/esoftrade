package ma.esoftech.esoftrade.controller;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.service.IUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ManagerUser")
public class UserManager {

	private static Logger  logger=Logger.getLogger(UserManager.class);
	@ Autowired
	IUserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute UserDTO userDTO, BindingResult result) {
 
		if (result.hasErrors()) {
			return "createUser";
		} else {
			userService.createUser(userDTO);
			return "hello";
		}
 
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
public String DisplayUserForm(ModelMap model){
    UserDTO userDto=new UserDTO();
	model.addAttribute("user",userDto);
	return"createUser";
}


}
