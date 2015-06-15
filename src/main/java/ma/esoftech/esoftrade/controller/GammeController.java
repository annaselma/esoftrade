package ma.esoftech.esoftrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.GammeDTO;
import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.exception.GammeNotFoundException;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;
import ma.esoftech.esoftrade.exception.NomenclatureNotFoundException;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.IGammeService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.service.IPosteService;
import ma.esoftech.esoftrade.serviceImpl.GammeServiceImpl;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
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
@RequestMapping("gamme")
public class GammeController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/gamme/profile";
	@Autowired
	IManufacturingOrderService manufacturingService;
	@Autowired
	IFileService fileService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	IPosteService posteService;
	@Autowired
	SessionBean sessionBean;
	@Autowired
	IGammeService gammeService;
	UserDTO currentUser;
	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadGamme(@RequestParam long id, ModelMap model,@RequestParam(required=false,defaultValue="false") boolean file){
		GammeDTO gammeDTO=null;
		try {
			 gammeDTO=gammeService.findById(id);
			
		} catch (GammeNotFoundException e) {
			// TODO Auto-generated catch block
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		FileUploadUTILS.prepareTabProfil(model, file);
        model.addAttribute("gamme", gammeDTO);
		return "gammeProfile";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadGammeCreateForm(@RequestParam(value="of_id") long of_id,ModelMap model) {
		initialize();
		OrderManufacturingDTO manufacturing;
		try {
			manufacturing=manufacturingService.findOFById(of_id);
		} catch (ManufacturingNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		GammeDTO gamme= new GammeDTO();
		model.addAttribute("gamme", gamme);
		model.addAttribute("manufacturingDTO",manufacturing);
		model.addAttribute("manufacturing", of_id);
		return "createGamme";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addGamme(@ModelAttribute("gamme") @Valid GammeDTO gammeDTO,
			BindingResult result,@RequestParam(value="manufacturing")long of_id,ModelMap model) {
		initialize();
		OrderManufacturingDTO manufacturing;
		try {
			manufacturing=manufacturingService.findOFById(of_id);
		} catch (ManufacturingNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			e.printStackTrace();
			return "error";
		}
		if (result.hasErrors()) {
			model.addAttribute("manufacturingDTO",manufacturing);
			model.addAttribute("manufacturing",of_id);
			return "createGamme";
		} else {
				long id=gammeService.createGamme(gammeDTO, currentUser);
				gammeDTO.setId(id);
				try {
					manufacturingService.attachGammeToManufacturing(gammeDTO,of_id, currentUser);
				} catch (ManufacturingNotFoundException e) {
					e.printStackTrace();
					model.addAttribute("messageError",e.getMessage());
					return "error";
				}
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateGammePage(@RequestParam long id, ModelMap model){
		 GammeDTO gamme=null;
		try {
			gamme=gammeService.findById(id);
		} catch (GammeNotFoundException e) {
			e.printStackTrace();
		}
		 
		 model.addAttribute("gamme",gamme);
		 return"updateGamme";
	 }
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateGamme( @ModelAttribute("gamme") @Valid GammeDTO gammeDTO, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "updateGamme";
		}
		initialize();
		try {
			gammeService.updateGamme(gammeDTO, currentUser);
		} catch (GammeNotFoundException e) {
			model.addAttribute(e.getMessage());
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+gammeDTO.getId();
	}
	
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteGamme(@RequestParam long id,@RequestParam(value="of_id")long of_id,ModelMap model){
		initialize();
	GammeDTO gammeDTO=new GammeDTO();
	 gammeDTO.setId(id);
	 try {
		manufacturingService.deleteGammefromManufacturing(gammeDTO, of_id, currentUser);
	} catch (ManufacturingNotFoundException e) {
		model.addAttribute("messageError",e.getMessage());
		return "error";
	}
	 return ManufacturingController.PATH_PROFIL+"?id="+of_id;
	}
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<GammeDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,@RequestParam(value="of_id") long of_id,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		OrderManufacturingDTO manufacturing=new OrderManufacturingDTO();
		manufacturing.setId(of_id);
		Order ordre=Order.createOrderFromRequestTable(req);
		String search=req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start=req.getStart();
		int  length=req.getLength();
		int draw=req.getDraw();
		List<GammeDTO> list= gammeService.getGammeByManufacturing(start, length, ordre.toString(),search , manufacturing);
		long recordsFiltered=gammeService.gammeCountByManufacturing(search, manufacturing);
		long recordsTotal=gammeService.gammeCountByManufacturing(search, manufacturing);
		ResponseTable<GammeDTO> response=new ResponseTable<GammeDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(list);
		return response;
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
			
			gammeService.attachFileToGamme(fileDTO, id, currentUser);
		} catch (IOException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (GammeNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		 return PATH_PROFIL+"?id="+id+"&file=true";
	}
	@ModelAttribute("postItems")
	public List<PosteDTO> getCategoryList(){
       List<PosteDTO> listPost=posteService.getAllPoste(0, 1000, null, null);
		return listPost;
	}
	
}
