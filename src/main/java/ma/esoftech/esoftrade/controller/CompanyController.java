package ma.esoftech.esoftrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.CompanyNotFoundException;
import ma.esoftech.esoftrade.model.Company.CompanyType;
import ma.esoftech.esoftrade.service.ICompanyService;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;
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
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/third")
public class CompanyController extends AbstractController {
	private static final String REDIRECT = "redirect:";
	private static final String PATH_PROFIL = REDIRECT + "/third/profile";

	@Autowired
	ICompanyService companyService;
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

	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadProfilePage(@RequestParam long id, ModelMap model,
			@RequestParam(required = false, defaultValue = "false") boolean file) {
		CompanyDTO company = null;
		try {
			company = companyService.findById(id);
		} catch (CompanyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileUploadUTILS.prepareTabProfil(model, file);
		model.addAttribute("company", company);
		return "companyProfile";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String loadAddPage(@RequestParam(required=false,defaultValue="all")CompanyType type,ModelMap model){
		CompanyDTO company=new CompanyDTO();
		switch(type){
		case customer:
			company.setCustomer(true);
			company.setSupplier(false);
			break;
		case supplier:
			company.setCustomer(false);
			company.setSupplier(true);
			break;
		default:
			company.setCustomer(true);
			company.setSupplier(true);
			break;
		}
		model.addAttribute("company", company);
		return "createCompany";
	}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCompany(@ModelAttribute("company") @Valid CompanyDTO company,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createCompany";
		} else {
            
				long id=companyService.createCompany(company, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String loadupdatePage(@RequestParam long id,ModelMap model){
		CompanyDTO company=null;
		try {
			company=companyService.findById(id);
		} catch (CompanyNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		model.addAttribute("company",company);
		return "updateCompany";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCompany(@ModelAttribute("company") @Valid CompanyDTO company,
			BindingResult result,ModelMap model) {
		initialize();
		if (result.hasErrors()) {
			return "updateCompany";
		} else {
            
				try {
					companyService.updateCompany(company, currentUser);
				} catch (CompanyNotFoundException e) {
					model.addAttribute("messageError",e.getMessage());
					return "error";
				}
				return PATH_PROFIL+"?id="+company.getId();
			}
			
		}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteCompany(@RequestParam long id){
		CompanyDTO company= new CompanyDTO();
		company.setId(id);
		companyService.deleteCompany(company);
		return "redirect:/product/list";
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadListProfil(@RequestParam(defaultValue="all") CompanyType type,ModelMap model){
		 switch(type){
		case all:
			model.addAttribute("companyType", "all");
			break;
		case customer:
			model.addAttribute("companyType", "customer");
			break;
		case supplier:
			model.addAttribute("companyType", "supplier");
			break;
		default:
			model.addAttribute("companyType", "all");
			break;
		 }
		 return "companyList";
	 }
	
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<CompanyDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,@RequestParam(value="type")CompanyType type,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		Order ordre=Order.createOrderFromRequestTable(req);
		String search=req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start=req.getStart();
		int  length=req.getLength();
		int draw=req.getDraw();
		List<CompanyDTO> companies=null;
		long recordsFiltered=0,recordsTotal=0;
		switch(type){
		case customer:
			companies=companyService.getCustomers(start, length, ordre.toString(), search);
			recordsFiltered=companyService.customersCount(search);
			recordsTotal=companyService.customersCount("");
			break;
		case supplier:
			companies=companyService.getSuppliers(start, length, ordre.toString(), search);
			recordsFiltered=companyService.suppliersCount(search);
			recordsTotal=companyService.suppliersCount("");
			break;
		default:
			companies=companyService.getCompanies(start, length, ordre.toString(), search);
			recordsFiltered=companyService.companiesCount(search);
			recordsTotal=companyService.companiesCount("");
			break;
		
		}
		ResponseTable<CompanyDTO> response=new ResponseTable<CompanyDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(companies);
		return response;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<CompanyDTO> searchProducts(@RequestParam CompanyType type,@RequestParam String search,ModelMap model){
		switch(type){
		case all:
			return  companyService.searchCompany(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
		case customer:
			return  companyService.searchCustomer(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
		case supplier:
			return  companyService.searchSupplier(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
		}
		return null;
		
	}
	@RequestMapping(value="/detachFile",method=RequestMethod.GET)
	public String detachFile(@RequestParam(value = "id")long id,@RequestParam(value="file_id")long fileId){
		initialize();
		
		FileDTO file=new FileDTO();
		file.setId(fileId);
		try {
			companyService.dettachFileFromCompany(file, id, currentUser);
		} catch (CompanyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			
			companyService.attachFileToCompany(fileDTO, id, currentUser);
		} catch (IOException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (CompanyNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		 return PATH_PROFIL+"?id="+id+"&file=true";
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

			companyService.updatePicture(picture, id, currentUser);
		} catch (IOException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (CompanyNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		 return PATH_PROFIL+"?id="+id;
	}
}
