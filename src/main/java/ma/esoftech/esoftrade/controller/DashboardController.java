package ma.esoftech.esoftrade.controller;

import java.util.Date;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.service.IDashboardService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends AbstractController{
@Autowired
IDashboardService dashboardService;
@Autowired
IManufacturingOrderService manufacturingService;

	@RequestMapping(method = RequestMethod.GET)
	public String loadDash(ModelMap model){
		Date currentDate= new Date();
		
		long blockCount=dashboardService.getCountOFBlocked();
		long lateCount= dashboardService.getCountOFLate(currentDate);
		long ProcessingCount=dashboardService.getCountOFProcessing();
		long waitingCount=dashboardService.getCountOFWaiting();
		model.addAttribute("OFBlocked", blockCount);
		model.addAttribute("OFLate", lateCount);
		model.addAttribute("OFProcessing", ProcessingCount);
		model.addAttribute("OFWaiting",waitingCount);
		return "dashboard";
	}
	public DashboardController(){
		
	}

}
