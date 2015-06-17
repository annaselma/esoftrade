package ma.esoftech.esoftrade.controller;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.DTO.PermissionDTO;
import ma.esoftech.esoftrade.DTO.RoleDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.RoleNotFoundException;
import ma.esoftech.esoftrade.service.IRoleService;
import ma.esoftech.esoftrade.utils.UTILS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController extends AbstractController {
	
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/role/profile";
	@Autowired
	IRoleService roleService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;

	public RoleController() {

	}

	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String loadRole(@RequestParam long id, ModelMap model) {
		RoleDTO role = null;
		try {
			role = roleService.findById(id);
		} catch (RoleNotFoundException e) {
			model.addAttribute("messageError","user how id="+id+"doesn't exist");
			return "error";
		}

		model.addAttribute("role", role);

		return "roleProfile";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") @Valid RoleDTO role,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createRole";
		} else {
			//role.getPermissions().removeAll(Collections.singleton(null));
			System.out.println(role.getPermissions().size()+"loool");
			for (PermissionDTO  perm :role.getPermissions()) {
			 System.out.println(perm);
			 System.out.println("lool");
			}
				long id=roleService.createRole(role, currentUser);
				
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadRoleCreateForm(ModelMap model) {
		initialize();
		RoleDTO role=new RoleDTO();
		model.addAttribute("role", role);
		return "createRole";
	}
	
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String deleteRole(@RequestParam long id,ModelMap model){
		 RoleDTO role=new RoleDTO();
		role.setId(id);;
		try {
			roleService.deleteRole(role);
		} catch (RoleNotFoundException e) {
			model.addAttribute("messageError","user how id="+role.getId()+"doesn't exist");
			return "error";
		}
		return "redirect:/role/list";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateRole( @ModelAttribute("role") @Valid RoleDTO role, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "updateRole";
		}
		initialize();
		try {
			roleService.updateRole(role, currentUser);
		} catch (RoleNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+role.getId();
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateRolePage(@RequestParam long id, ModelMap model){
		RoleDTO role=null;
		try {
			role = roleService.findById(id);
		} catch (RoleNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		 
		 model.addAttribute("role",role);
		
		 return"updateRole";
	 }
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadRoleListProfil(ModelMap model){
		 
		 return "roleList";
	 }
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<RoleDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		Order ordre=Order.createOrderFromRequestTable(req);
		String search=req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start=req.getStart();
		int  length=req.getLength();
		int draw=req.getDraw();
		List<RoleDTO> list=roleService.getRoles(start, length, ordre.toString(), search);
		long recordsFiltered=roleService.RoleCount(search);
		long recordsTotal=roleService.RoleCount("");
		ResponseTable<RoleDTO> response=new ResponseTable<RoleDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(list);
		return response;
	}
	@ModelAttribute("permissions")
	public List<PermissionDTO> getCategoryList(){
		// List<PCategoryDTO> listCategory=categoryService.getListCategory(0, 1000);
		List<PermissionDTO> list=roleService.getPermissions(UTILS.START_LIST, UTILS.MAX_LENGHT_LIST);
		return list;
	}
	@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<PermissionDTO> searchPermissions(@RequestParam String search,ModelMap model){
		
		return roleService.searchPermissions(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
	}
	
	@RequestMapping(value="/searchRolesNotIn",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<RoleDTO> searchRoleNotIN(@RequestParam long id,@RequestParam String search){
      UserDTO user=new  UserDTO();
      user.setId(id);
      return roleService.searchRoleNotIN(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST,user, search);
    }
	
	

}
