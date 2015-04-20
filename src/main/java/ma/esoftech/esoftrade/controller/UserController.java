package ma.esoftech.esoftrade.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.PasswordDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exeption.UserNameException;
import ma.esoftech.esoftrade.exeption.UserNotFoundException;
import ma.esoftech.esoftrade.generate.Entity;
import ma.esoftech.esoftrade.service.IUserService;
import ma.esoftech.esoftrade.service.ServiceUtils;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/user/profile";

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
			return PATH_PROFIL+"?id="+user.getId();
		}

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadUserCreateForm(ModelMap model) {
		initialize();
		UserDTO userDto = new UserDTO();
		model.addAttribute("user", userDto);
		return "createUser";
	}
	
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteUser(@RequestParam long id){
		 UserDTO user= new UserDTO();
		user.setId(id);
		userService.deleteUser(user);
		return "redirect:/user/list";
	}
	 @RequestMapping(value="/update",method=RequestMethod.POST)
	public String UpdateUser(@ModelAttribute("user")  @Valid UserDTO user, BindingResult result,ModelMap model){
		PasswordDTO passwoDto=new PasswordDTO();
		passwoDto.setId(user.getId());
		 if(result.hasErrors()){
			 System.out.println("errrurre");
			 model.addAttribute("password", passwoDto);
			return "updateUser";
			}
		initialize();
		try {
			userService.updateUser(currentUser, user);
		} catch (UserNameException e) {
			result.rejectValue("login", "login.error.exist",
					"login exsist!!");
			model.addAttribute("password", passwoDto);
			return "updateUser";
		} catch (UserNotFoundException e) {
			model.addAttribute("messageError","user how id="+user.getId()+"doesn't exist");
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+user.getId();
	}
	 @RequestMapping(value="/editPassword",method=RequestMethod.POST)
	 public String ediPassword(@ModelAttribute("password")  @Valid PasswordDTO password,BindingResult resullt,ModelMap model){
		 UserDTO user=userService.findById(password.getId());
		 if(resullt.hasErrors()){
			 if(user==null)
				 user=new UserDTO();
			 model.addAttribute("user",user);
			 return "updateUser";
		 }
		 if(!password.getPassword1().equals(password.getPassword2())){
			 resullt.rejectValue("password1","login.password.notEquals","passwords is not equals");
			 if(user==null)
				 user=new UserDTO();
			 model.addAttribute("user",user);
			 return "updateUser";
		 }
		 try {
			userService.editPassword(password.getPassword1(),password.getId());
		} catch (UserNotFoundException e) {
			model.addAttribute("messageError","user how id="+password.getId()+"doesn't exist");
			return "error";
		}
		 
		 return PATH_PROFIL+"?id="+password.getId();
	 }
	 @RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateUserPage(@RequestParam long id, ModelMap model){
		 UserDTO user=userService.findById(id);
		 if(user==null){
			 model.addAttribute("messageError","user how id="+id+"doesn't exist ");
			 return "error";
		 }
		 PasswordDTO password=new PasswordDTO();
		 password.setId(id);
		 model.addAttribute("password", password);
		 model.addAttribute("user",user);
		 return"updateUser";
	 }
	 
	 @RequestMapping(value="/profile",method=RequestMethod.GET)
	 public String loadProfile(@RequestParam long id, ModelMap model){
		 UserDTO user= userService.findById(id);
		 if(user== null){
			 model.addAttribute("messageError","user how id="+id+"doesn't exist ");
			 return "error";
		 }
		 model.addAttribute("user", user);
		 return "profile";
	 }
	 @RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadUSerListProfil(ModelMap model){
		 
		 return "userList";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<UserDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<UserDTO> list=userService.getAllUsers(start, length, ordre.toString(),search);
			long recordsFiltered=userService.userCount(search);
			long recordsTotal=userService.userCount("");
			ResponseTable<UserDTO> response=new ResponseTable<UserDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}

}
