package ma.esoftech.esoftrade.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.GammeDTO;
import ma.esoftech.esoftrade.DTO.NomenclatureDTO;
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
import ma.esoftech.esoftrade.service.IGammeService;
import ma.esoftech.esoftrade.service.IManufacturingOrderService;
import ma.esoftech.esoftrade.service.INomenclatureService;
import ma.esoftech.esoftrade.service.IUserService;
import ma.esoftech.esoftrade.service.IWarehouseService;
import ma.esoftech.esoftrade.utils.FileUploadUTILS;
import ma.esoftech.esoftrade.utils.UTILS;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

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
	public static final String PATH_PROFIL=REDIRECT+"/manufacturing/profile";
	@Autowired
	IManufacturingOrderService manufacturService;
	@Autowired
	INomenclatureService nomenclatureService;
	@Autowired
	IUserService userService;
	@Autowired
	IGammeService gammeService;
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
	public String loadOF(@RequestParam long id, ModelMap model,@RequestParam(required=false)String stock,@RequestParam(required=false,defaultValue="false") boolean file){
		OrderManufacturingDTO OF=null;Map<String, Float>map=null;
		try {
			
			OF= manufacturService.findOFById(id);
			 map=manufacturService.calculeCost(id);
		} catch (ManufacturingNotFoundException e) {
			model.addAttribute("messageError","OF with id="+ id+"doesn't exist");
			return "error";
		}
		FileUploadUTILS.prepareTabProfil(model, file);
		model.addAttribute("thCost", map.get("thCost"));
		model.addAttribute("realCost", map.get("realCost"));
		model.addAttribute("thUnitCost", map.get("thUnitCost"));
		model.addAttribute("realUnitCost", map.get("realUnitCost"));
        model.addAttribute("manufacturing", OF);
        if(stock!=null)
         model.addAttribute("stock", "ddd");
		
		return "manufacturingProfile";
		}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addOF(@ModelAttribute("manufacturing") @Valid OrderManufacturingDTO manufacturingOrder,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createManufacturing";
		} else {
            
			
				long id=manufacturService.createOF(manufacturingOrder, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadOFCreateForm(ModelMap model) {
		System.out.println("hello"+FileUploadUTILS.getPathFile());
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
				e.printStackTrace();
				return "error";
			} catch (ManufacturingNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				e.printStackTrace();
				return "error";
			}
			 return PATH_PROFIL+"?id="+id+"&file=true";
		}
		
		
		@RequestMapping(value="pdf",method = RequestMethod.GET)
		public void getPdfById(HttpServletResponse response,@RequestParam(required=false) long id){
			try {
							      

				JasperReport jasperReport =    JasperCompileManager.compileReport(getClass().getResource("/of2.jrxml").getPath());
				Map<String, Object> parameters=new HashMap<String, Object>();
				OrderManufacturingDTO manufacturingDTO=manufacturService.findOFById(id);
				List<NomenclatureDTO> dataList =nomenclatureService.getNomenclaturesByManufacturing(UTILS.START_LIST,
						UTILS.MAX_LENGHT_LIST,"","",manufacturingDTO );
				List<GammeDTO> gammeList=gammeService.getGammeByManufacturing(UTILS.START_LIST,
						UTILS.MAX_LENGHT_LIST,"provisionalStartDate ASC","",manufacturingDTO );
			      JRBeanCollectionDataSource beanColDataSource =
			      new JRBeanCollectionDataSource(dataList);
System.out.println(gammeList.size());
				   parameters.put("of", manufacturingDTO);
				   parameters.put("nomenclatures",dataList);
				   parameters.put("gammes", gammeList);
				   
               
				      JasperPrint jp=null;
				      try {
				    	 //new net.sf.jasperreports.engine.data.JRBeanCollectionDataSource($P{gammes})
				       // jp= JasperFillManager.fillReport(
				         //jasperReport, parameters,new JREmptyDataSource());
				    	  jp= JasperFillManager.fillReport(
							         jasperReport, parameters,beanColDataSource);
				      } catch (JRException e) {
				         e.printStackTrace();
				      }
				      JRPdfExporter exporter = new JRPdfExporter();
				      ByteArrayOutputStream output = new ByteArrayOutputStream();
				      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
				      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, output);
				      exporter.exportReport();
				      byte[] bytes=output.toByteArray();
				      System.out.println(bytes.length);
				      response.getOutputStream().write(bytes,0,bytes.length); 	   
				      response.setContentType("application/pdf");
				        response.setHeader("Content-Disposition","attachment; filename=\"OF.pdf\"");
				        response.setContentLength(bytes.length);
			} catch (JRException | IOException | ManufacturingNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		
		
		@ModelAttribute("warehouseItems")
		public List<WarehouseDTO> getWarehList(){
			 List<WarehouseDTO> listwarehouse=warehouseService.getListWarehouse(0, 1000);
				return listwarehouse;
		}
		
		@RequestMapping(value="/searchResponsable",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody List<UserDTO> searchResponsable(@RequestParam String search,ModelMap model){
			return  manufacturService.searchResponsable(UTILS.MAX_LENGHT_LIST, UTILS.START_LIST, search);
		}
		@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody List<WarehouseDTO> searchCenter(@RequestParam String search,ModelMap model){
			System.out.println("search");
			return  manufacturService.searchWarehouse(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
		}
		
}
