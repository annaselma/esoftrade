package ma.esoftech.esoftrade.controller;

import java.util.Date;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.exeption.UserNameException;
import ma.esoftech.esoftrade.service.IUserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {

	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	@Autowired
	SessionBean sessionBean;

	UserDTO currentUser;

	public UserController() {
		
	}

	private void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid UserDTO user,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createUser";
		} else {
			try {

				userService.createUser(currentUser, user);
			} catch (UserNameException e) {
				result.rejectValue("login", "login.error.exist",
						"login exsist!!");
				return "createUser";
			}
			return "hello";
		}

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String DisplayUserForm(ModelMap model) {
		initialize();
		UserDTO userDto = new UserDTO();
		model.addAttribute("title", "gotit");
		model.addAttribute("user", userDto);
		return "createUser";
	}

}
