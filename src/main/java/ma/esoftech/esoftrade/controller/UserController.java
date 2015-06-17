package ma.esoftech.esoftrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.PasswordDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.associated.FileAssociatedDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.RoleNotFoundException;
import ma.esoftech.esoftrade.exception.UserNameException;
import ma.esoftech.esoftrade.exception.UserNotFoundException;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.IPosteService;
import ma.esoftech.esoftrade.service.IRoleService;
import ma.esoftech.esoftrade.service.IUserService;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/user/profile";

	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	IRoleService roleService;
	@Autowired
	IUserService userService;
	@Autowired
	IPosteService posteService;
	@Autowired
	IFileService fileService;
	@Autowired
	ServletContext servletContext;

	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;

	
	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}


	public UserController() {
		
	}



	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") @Valid UserDTO user,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createUser";
		} else {
			try {
				long id=userService.createUser(currentUser, user);
				user.setId(id);
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
		 return "userProfile";
	 }
	 @RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadUSerListProfil(ModelMap model){
		 
		 return "userList";
	 }
	 
	 
	 @RequestMapping(value="/addRole",method=RequestMethod.POST)
	 public String addRole(@RequestParam long id, @RequestParam long role,ModelMap model){
		 UserDTO user=userService.findById(id);
		 RoleDTO roleDTO=null;
	if(user==null){
		 
	}
	try {
        roleDTO=roleService.findById(role);
	} catch (RoleNotFoundException e) {
		model.addAttribute("messageError","no user found");
		return "error";
	}
	userService.addRoleToUser(roleDTO, user);	 
		 return PATH_PROFIL+"?id="+id+"&file=true";
	 }
	 
	 @RequestMapping(value="/deleteRole",method=RequestMethod.GET)
	 public String deleteRole(@RequestParam long id, @RequestParam long role,ModelMap model){
		 UserDTO user=userService.findById(id);
		 RoleDTO roleDTO=null;
	if(user==null){
		 
	}
	try {
        roleDTO=roleService.findById(role);
	} catch (RoleNotFoundException e) {
		model.addAttribute("messageError","no user found");
		return "error";
	}
	userService.deleteRoleFromUser(roleDTO, user);	 
		 return PATH_PROFIL+"?id="+id+"&file=true";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<UserDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
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
		@RequestMapping(value="/getListWhereRole",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<UserDTO> loadTables2(@Valid RequestTable req,BindingResult bindingResult,@RequestParam long id,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			RoleDTO role=new RoleDTO();
			role.setId(id);
			List<UserDTO> list=userService.getUsersByRole(start, length, ordre.toString(),role,search);
			long recordsFiltered=userService.userCountByRole(role,search);
			long recordsTotal=userService.userCountByRole(role,"");
			ResponseTable<UserDTO> response=new ResponseTable<UserDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/getCurrentUser",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody UserDTO getCurrentUser(ModelMap model){
		initialize();
          return currentUser;
        }
		
		@RequestMapping(value="/image",method=RequestMethod.POST)
		public String uploadImage(@RequestParam(value = "file") MultipartFile file,@RequestParam long id,ModelMap model){
		
			initialize();
			
			if(file.isEmpty()){
				 model.addAttribute("messageError","no file exist ");
				 return "error";	
			}
			try {
				FileDTO fileDTO=fileService.createFile(file.getBytes(), file.getOriginalFilename(),FileUploadUTILS.getPathFile()
						, currentUser);
				UserDTO user=userService.findById(id);
				FileAssociatedDTO picture=new FileAssociatedDTO();
				picture.setId(fileDTO.getId());
				user.setPicture(picture);
				userService.updatePicture(fileDTO, id, currentUser);
			} catch (IOException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			} catch (UserNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
			 return PATH_PROFIL+"?id="+id+"&file=true";
		}
		@ModelAttribute("rolesItems")
		public List<RoleDTO> getRoles(){
			List<RoleDTO> roles=null;
			return roles;
		}
		@ModelAttribute("postItems")
		public List<PosteDTO> getCategoryList(){
//			List<PosteDTO> listPost=posteService.getAllPoste(0, 1000, null, null);
			List<PosteDTO> listPost=null;
			return listPost;
		}

}
