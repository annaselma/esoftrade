package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.validation.Valid;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.exeption.WarehouseNotFoundException;
import ma.esoftech.esoftrade.service.IWarehouseService;
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
@RequestMapping("/warehouse")
public class WarehouseController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/warehouse/profile";
	@Autowired
	IWarehouseService warehouseService;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;
public WarehouseController(){}

private void initialize() {
	this.currentUser = sessionBean.getUserDTO();
}

@RequestMapping(value="/profile",method = RequestMethod.GET)
public String loadWarehouse(@RequestParam long id, ModelMap model){
	WarehouseDTO warehouse=null;
	try {
		
		warehouse= warehouseService.findById(id);
	} catch (WarehouseNotFoundException e) {
		model.addAttribute("messageError","warehouse with id="+ id+"doesn't exist");
		return "error";
	}

    model.addAttribute("wrehouse", warehouse);
	
	return "warehouseProfile";
	}


@RequestMapping(value = "/create", method = RequestMethod.POST)
public String addWarehouse(@ModelAttribute("warehouse") @Valid WarehouseDTO warehouse,
		BindingResult result) {
	initialize();
	if (result.hasErrors()) {
		return "createWarehouse";
	} else {
        
		try {
			long id=warehouseService.createWarehouse(warehouse, currentUser);
			warehouse.setId(id);
		} catch (Exception e) {
			result.rejectValue("name", "name.error.exist.warehouse",
					"name exsist!!");
			return "createWarehouse";
		}
			return PATH_PROFIL+"?id="+warehouse.getId();
		}
		
	}
@RequestMapping(value = "/create", method = RequestMethod.GET)
public String loadWarehouseCreateForm(ModelMap model) {
	initialize();
	WarehouseDTO warehousedto= new WarehouseDTO();
	model.addAttribute("warehouse",warehousedto );
	return "createWarehouse";
}
@RequestMapping(value="/delete",method= RequestMethod.GET)
public String Deletewarehouse(@RequestParam long id){
	 WarehouseDTO warehousedto= new WarehouseDTO();
	warehousedto.setId(id);
	warehouseService.deleteWarehouse(warehousedto);
	return "redirect:/warehouse/list";
}
@RequestMapping(value="/update", method=RequestMethod.POST)
public String updateWarehouse( @ModelAttribute("warehouse") @Valid WarehouseDTO warehousedto, BindingResult result,ModelMap model){
	if(result.hasErrors()){
		return "createWarehouse";
	}
	initialize();
	try {
		warehouseService.updateWarehouse(warehousedto, currentUser);
	} catch (WarehouseNotFoundException e) {
		result.rejectValue("name", "name.error.exist.warehouse",
				"name exsist!!");
		
		return "updateWarehouse";
	}

	 return PATH_PROFIL+"?id="+warehousedto.getId();
}
@RequestMapping(value="/update",method=RequestMethod.GET)
 public String loadUpdateWarehousePage(@RequestParam long id, ModelMap model){
	 WarehouseDTO warehousedto=null;
	try {
		warehousedto = warehouseService.findById(id);
	} catch (WarehouseNotFoundException e) {
		e.printStackTrace();
	}
	 if(warehousedto==null){
		 model.addAttribute("messageError","warehouse how id="+id+"doesn't exist ");
		 return "error";
	 }
	 model.addAttribute("warehouse",warehousedto);
	 return"updateWarehouse";
 }
@RequestMapping(value="/list",method=RequestMethod.GET)
 public String loadWarehouseListProfil(ModelMap model){
	 
	 return "warehouseList";
 }
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<WarehouseDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		Order ordre=Order.createOrderFromRequestTable(req);
		String search=req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start=req.getStart();
		int  length=req.getLength();
		int draw=req.getDraw();
		List<WarehouseDTO> list=warehouseService.getListWarehouse(start, length, ordre.toString(), search);
		long recordsFiltered=warehouseService.warehouseCount(search);
		long recordsTotal=warehouseService.warehouseCount("");
		ResponseTable<WarehouseDTO> response=new ResponseTable<WarehouseDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(list);
		return response;
	}
}
