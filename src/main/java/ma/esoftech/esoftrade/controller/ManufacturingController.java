package ma.esoftech.esoftrade.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.service.IUserService;
import ma.esoftech.esoftrade.service.IWarehouseService;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;

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
@RequestMapping("/manufacturing")
public class ManufacturingController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/manufacturing/profile";
	@Autowired
	IManufacturingOrderService manufacturService;
	@Autowired
	IUserService userService;
	@Autowired
	IWarehouseService warehouseService;
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
	public ManufacturingController() {

	}
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadOF(@RequestParam long id, ModelMap model,@RequestParam(required=false,defaultValue="false") boolean file){
		OrderManufacturingDTO OF=null;
		try {
			
			OF= manufacturService.findOFById(id);
		} catch (ManufacturingNotFoundException e) {
			model.addAttribute("messageError","OF with id="+ id+"doesn't exist");
			return "error";
		}
		FileUploadUTILS.prepareTabProfil(model, file);
        model.addAttribute("manufacturing", OF);
		
		return "manufacturingProfile";
		}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addOF(@ModelAttribute("manufacturing") @Valid OrderManufacturingDTO manufacturingOrder,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createManufacturing";
		} else {
            
			//ahh tu as initialsé par null provisoire
			      manufacturingOrder.setProduct(null);
				long id=manufacturService.createOF(manufacturingOrder, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadOFCreateForm(ModelMap model) {
		initialize();
		OrderManufacturingDTO manufacte=new OrderManufacturingDTO();
		model.addAttribute("manufacturing", manufacte);
		return "createManufacturing";
	}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteOF(@RequestParam long id){
		 OrderManufacturingDTO manufacturing= new OrderManufacturingDTO();
		 manufacturService.deleteOF(manufacturing);
		return "redirect:/manufacturing/list";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOF( @ModelAttribute("manufacturing") @Valid OrderManufacturingDTO manufact, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "updateManufacturing";
		}
		initialize();
		try {
			manufacturService.updateOF(manufact, currentUser);
		} catch (ManufacturingNotFoundException e) {
			model.addAttribute("messageError","manufacturing how id="+manufact.getId()+"doesn't exist");
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+manufact.getId();
	}
	

	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateOFPage(@RequestParam long id, ModelMap model){
		OrderManufacturingDTO manufactOrder=null;
		try {
			manufactOrder= manufacturService.findOFById(id);
		} catch (ManufacturingNotFoundException e) {
			e.printStackTrace();
		}
		 if(manufactOrder==null){
			 model.addAttribute("messageError","manufacturOrder how id="+id+"doesn't exist ");
			 return "error";
		 }
		 model.addAttribute("manufacturing",manufactOrder);
		
		 return"updateManufacturing";
	 }
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadOFListProfil(ModelMap model){
		 
		 return "manufacturingList";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<OrderManufacturingDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<OrderManufacturingDTO> list=manufacturService.getAllOF(start, length, ordre.toString(), search);
			long recordsFiltered=manufacturService.OrderFacturingCount(search);
			long recordsTotal=manufacturService.OrderFacturingCount("");
			ResponseTable<OrderManufacturingDTO> response=new ResponseTable<OrderManufacturingDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/image",method=RequestMethod.POST)
		public String uploadImage(@RequestParam(value = "file") MultipartFile file,@RequestParam long id,ModelMap model){
		
			initialize();
			
			if(file.isEmpty()){
				 model.addAttribute("messageError","no file exist ");
				 return "error";	
			}
			try {
				FileDTO picture=fileService.createFile(file.getBytes(), file.getOriginalFilename(),
						FileUploadUTILS.getPathFile(), currentUser);

				manufacturService.updatePicture(picture, id, currentUser);
			} catch (IOException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			} catch (ManufacturingNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
			 return PATH_PROFIL+"?id="+id+"&file=true";
		}
		@RequestMapping(value="/upload",method=RequestMethod.POST)
		public String uploadAttachedFile(@RequestParam(value = "file") MultipartFile file,@RequestParam long id,ModelMap model){
		
			initialize();
			
			if(file.isEmpty()){
				 model.addAttribute("messageError","no file exist ");
				 return "error";			
			}
			try {
				FileDTO fileDTO=fileService.createFile(file.getBytes(), file.getOriginalFilename(),
						FileUploadUTILS.getPathFile(), currentUser);
				
				manufacturService.attachFileToManufacturing(fileDTO, id, currentUser);
			} catch (IOException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			} catch (ManufacturingNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
			 return PATH_PROFIL+"?id="+id+"&file=true";
		}
		
		
		@ModelAttribute("warehouseItems")
		public List<WarehouseDTO> getWarehList(){
			 List<WarehouseDTO> listwarehouse=warehouseService.getListWarehouse(0, 1000);
				return listwarehouse;
		}
		@ModelAttribute("userItems")
		public List<UserDTO> getUserList(){
			 List<UserDTO>listeUser=userService.getAllUsers(0, 1000, "", "");
				return listeUser;}
}
