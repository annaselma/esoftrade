package ma.esoftech.esoftrade.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.OrderManufacturingDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.model.OrderManufacturing;
import ma.esoftech.esoftrade.service.IDashboardService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
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
	@RequestMapping(value="/bubble_data",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody float[][] getBubbleData(ModelMap model){
		return  dashboardService.getOfStaticBubble();
	}
	@RequestMapping(value="/line_data",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody Object[][] getLineData(ModelMap model){
		return  dashboardService.getPostesStatic();
	}
	@RequestMapping(value="/pie_data",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody Map<String, Float[]> getPieData(ModelMap model){
		return  dashboardService.getPieData();
	}
	@RequestMapping(value="/calendar_events",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<Map<String,Object>> getevents(ModelMap model){
		return  dashboardService.getCalandarOrders();
	}
		
	public DashboardController(){
		
	}

}
