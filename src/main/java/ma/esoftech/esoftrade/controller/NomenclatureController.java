package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.ManufacturingNotFoundException;
import ma.esoftech.esoftrade.exception.NomenclatureNotFoundException;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.service.INomenclatureService;

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
@RequestMapping("nomenclature")
public class NomenclatureController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/nomenclature/profile";
	@Autowired
	INomenclatureService nomenclatureService;
	@Autowired
	IManufacturingOrderService manufacturingService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;
	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadNomenclature(@RequestParam long id, ModelMap model){
		try {
			NomenclatureDTO nomenclatureDTO=nomenclatureService.findById(id);
			model.addAttribute("nomenclature", nomenclatureDTO);
		} catch (NomenclatureNotFoundException e) {
			// TODO Auto-generated catch block
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		
		return "NomenclatureProfile";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadNomenclatureCreateForm(@RequestParam(value="of_id") long of_id,ModelMap model) {
		initialize();
		try {
			manufacturingService.findOFById(of_id);
		} catch (ManufacturingNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		NomenclatureDTO nomenclature=new NomenclatureDTO();
		model.addAttribute("nomenclature", nomenclature);
		model.addAttribute("manufacturing", of_id);
		return "createNomenclature";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addNomenclature(@ModelAttribute("nomenclature") @Valid NomenclatureDTO nomenclatureDTO,
			BindingResult result,@RequestParam(value="of_id")long of_id,ModelMap model) {
		initialize();
		
		if (result.hasErrors()) {
			model.addAttribute("manufacturing",of_id);
			return "createNomenclature";
		} else {
			try {
				manufacturingService.findOFById(of_id);
			} catch (ManufacturingNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
            
				long id=nomenclatureService.createNomenclature(nomenclatureDTO, currentUser);
				nomenclatureDTO.setId(id);
				try {
					manufacturingService.attachNomenclatureToManufacturing(nomenclatureDTO, of_id, currentUser);
				} catch (ManufacturingNotFoundException e) {
					model.addAttribute("messageError",e.getMessage());
					return "error";
				}
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateNomenclaturePage(@RequestParam long id, ModelMap model){
		 NomenclatureDTO nomenclature=null;
		try {
			nomenclature = nomenclatureService.findById(id);
		} catch (NomenclatureNotFoundException e) {
			e.printStackTrace();
		}
		 
		 model.addAttribute("nomenclature",nomenclature);
		 return"updateNomenclature";
	 }
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateNomenclature( @ModelAttribute("nomenclature") @Valid NomenclatureDTO nomenclature, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "updateNomenclature";
		}
		initialize();
		try {
			nomenclatureService.updateNomenclature(nomenclature, currentUser);
		} catch (NomenclatureNotFoundException e) {
			model.addAttribute(e.getMessage());
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+nomenclature.getId();
	}
	
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteNomenclature(@RequestParam long id,@RequestParam(value="of_id")long of_id,ModelMap model){
	 NomenclatureDTO nomenclatureDTO=new NomenclatureDTO();
	 nomenclatureDTO.setId(id);
	 try {
		manufacturingService.deleteNomenclaturefromManufacturing(nomenclatureDTO, of_id, currentUser);
	} catch (ManufacturingNotFoundException e) {
		model.addAttribute("messageError",e.getMessage());
		return "error";
	}
	 return ManufacturingController.PATH_PROFIL+"?id="+of_id;
	}
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<NomenclatureDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,@RequestParam(value="of_id") long of_id,ModelMap model){
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
		List<NomenclatureDTO> list= nomenclatureService.getNomenclaturesByManufacturing(start, length, ordre.toString(), search,manufacturing);
		long recordsFiltered=nomenclatureService.nomenclatureCountByManufacturing(search, manufacturing);
		long recordsTotal=nomenclatureService.nomenclatureCountByManufacturing("", manufacturing);
		ResponseTable<NomenclatureDTO> response=new ResponseTable<NomenclatureDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(list);
		return response;
	}
	@RequestMapping(value="/qteIm",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody  long getImportedQte(@RequestParam long id){
		return 0;
	}
}
