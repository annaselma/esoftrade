package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.CompanyDTO;
import ma.esoftech.esoftrade.DTO.ContactDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.associated.CompanyAssociatedDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.CompanyNotFoundException;
import ma.esoftech.esoftrade.exception.ContactNotFoundException;
import ma.esoftech.esoftrade.service.ICompanyService;
import ma.esoftech.esoftrade.service.IContactService;
import ma.esoftech.esoftrade.service.IFileService;
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
@RequestMapping("/contact")
public class ContactController extends AbstractController {
	private static final String REDIRECT = "redirect:";
	private static final String PATH_PROFIL = REDIRECT + "/contact/profile";

	@Autowired
	IContactService contactService;
	@Autowired
	ICompanyService companyService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;
	
	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}

	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadProfilePage(@RequestParam long id, ModelMap model) {
		ContactDTO contact=null;
		try {
			contact=contactService.findById(id);
		} catch (ContactNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("contact", contact);
		return "contactProfile";
	}
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String loadAddPage(@RequestParam(required=false,defaultValue="0",value="company_id")long companyId,ModelMap model){
		ContactDTO contact=new ContactDTO();
		CompanyAssociatedDTO company=new CompanyAssociatedDTO();
		try {
			CompanyDTO companyDTO=companyService.findById(companyId);
			company.setName(companyDTO.getName());
		} catch (CompanyNotFoundException e) {
			e.printStackTrace();
		}
		company.setId(companyId);
        contact.setCompany(company);
		model.addAttribute("contact",contact);
		return "createContact";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCompany(@ModelAttribute("contact") @Valid ContactDTO contact,
			BindingResult result,ModelMap model) {
		initialize();
		if (result.hasErrors()) {
			if(contact.getCompany()!=null && contact.getCompany().getId()>0){
			try {
				
				CompanyDTO companyDTO=companyService.findById(contact.getCompany().getId());
				contact.getCompany().setName(companyDTO.getName());
			} catch (CompanyNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
			}
			return "createContact";
		} else {
            
				long id=contactService.createContact(contact, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String loadupdatePage(@RequestParam long id,ModelMap model){
		ContactDTO contact=null;
		try {
			contact=contactService.findById(id);
		} catch (ContactNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		model.addAttribute("contact",contact);
		return "updateContact";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCompany(@ModelAttribute("contact") @Valid ContactDTO contact,
			BindingResult result,ModelMap model) {
		initialize();
		if (result.hasErrors()) {
			if(contact.getCompany()!=null && contact.getCompany().getId()>0){
				try {
					
					CompanyDTO companyDTO=companyService.findById(contact.getCompany().getId());
					contact.getCompany().setName(companyDTO.getName());
				} catch (CompanyNotFoundException e) {
					model.addAttribute("messageError",e.getMessage());
					return "error";
				}
				}
			
			return "updateContact";
		} else {
            
				try {
					contactService.updateContact(contact, currentUser);
				} catch (ContactNotFoundException e) {
					model.addAttribute("messageError",e.getMessage());
					return "error";
				}
				return PATH_PROFIL+"?id="+contact.getId();
			}
			
		}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String delete(@RequestParam long id,@RequestParam(defaultValue="0",value="company_id",required=false)  long companyId,ModelMap model){
		ContactDTO contact=new ContactDTO();
		contact.setId(id);
		try {
			contactService.deleteContact(contact);
		} catch (ContactNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		if(companyId>0){
		    return "redirect:/third/profile?id="+companyId;
		}else{
			return "redirect:/contact/list";
		}
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadListProfil(ModelMap model){
		 return "contactList";
	 }
	@RequestMapping(value = "/getList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseTable<ContactDTO> loadTables(
			@Valid RequestTable req,
			BindingResult bindingResult,
			@RequestParam(value = "company_id", defaultValue = "0",required=false) long companyId,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return null;
		}
		Order ordre = Order.createOrderFromRequestTable(req);
		String search = req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start = req.getStart();
		int length = req.getLength();
		int draw = req.getDraw();
		List<ContactDTO> contacts = null;
		long recordsFiltered = 0, recordsTotal = 0;
		CompanyDTO company=new CompanyDTO();
			company.setId(companyId);
		if (companyId > 0) {
			contacts=contactService.getListByCompany(start, length,ordre.toString(), company, search);
			recordsFiltered = contactService.countListByCompany(search, company);
			recordsTotal = contactService.countListByCompany("", company);
		} else {
			contacts=contactService.getList(start, length,ordre.toString(), search);
			recordsFiltered = contactService.countList(search);
			recordsTotal = contactService.countList("");
		}
		ResponseTable<ContactDTO> response = new ResponseTable<ContactDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(contacts);
		return response;
	}

	@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<ContactDTO> searchProducts(@RequestParam(value = "company_id", defaultValue = "0",required=false) long companyId,@RequestParam String search,ModelMap model){
		CompanyDTO company=new CompanyDTO();
		company.setId(companyId);
		if(companyId>0){
			return contactService.searchContactByCompany(UTILS.START_LIST,UTILS.MAX_LENGHT_LIST, search, company);
		}else{
			return contactService.searchContact(UTILS.START_LIST,UTILS.MAX_LENGHT_LIST, search);
		}
	}
	
}
