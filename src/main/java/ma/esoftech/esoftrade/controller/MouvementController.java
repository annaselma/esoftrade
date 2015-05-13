package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.MouvementDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.ProductWarehouseDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.WarehouseDTO;
import ma.esoftech.esoftrade.DTO.associated.ProductAssociatedDTO;
import ma.esoftech.esoftrade.DTO.associated.WarehouseAssociatedDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;
import ma.esoftech.esoftrade.exception.WarehouseNotFoundException;
import ma.esoftech.esoftrade.service.IMouvementService;
import ma.esoftech.esoftrade.service.IProductService;
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
@RequestMapping("mouvement")
public class MouvementController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/mouvement/profile";
	@Autowired
	IWarehouseService warehouseService;
	@Autowired
	IMouvementService mouventService;
	@Autowired
	IProductService productService;
	@Autowired
   SessionBean sessionBean;
	 
	UserDTO currentUser;
	public MouvementController(){}
	private void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadMouvementListPage(ModelMap model){
		 
		 return "mouvementlist";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<MouvementDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<MouvementDTO> list=mouventService.getListMouvement(start, length, ordre.toString(), search);
			long recordsFiltered=mouventService.MouvementCount(search);
			long recordsTotal=mouventService.MouvementCount("");
			ResponseTable<MouvementDTO> response=new ResponseTable<MouvementDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/getProductListByWarehouse",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<ProductWarehouseDTO> loadTableProduct(@Valid RequestTable req,BindingResult bindingResult,@RequestParam(value="id") long warehouseId,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			WarehouseDTO warehouseDTO=new WarehouseDTO();
			warehouseDTO.setId(warehouseId);
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<ProductWarehouseDTO> list=mouventService.getListProductByWarehouse(start, length, ordre.toString(), search, warehouseDTO);
					long recordsFiltered=mouventService.ProductCountByWarehouse(search, warehouseDTO);
			long recordsTotal=mouventService.ProductCountByWarehouse("", warehouseDTO);
			ResponseTable<ProductWarehouseDTO> response=new ResponseTable<ProductWarehouseDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		
		@RequestMapping(value="/getListByWarehouse",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<MouvementDTO> loadTablesByWarehouse(@Valid RequestTable req,BindingResult bindingResult,@RequestParam(value="id") long warehouseId,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			WarehouseDTO warehouseDTO=new WarehouseDTO();
			warehouseDTO.setId(warehouseId);
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<MouvementDTO> list=mouventService.getListMouvementByWarehouse(start, length, ordre.toString(), search, warehouseDTO);
			long recordsFiltered=mouventService.MouvementCountByWarehouse(search, warehouseDTO);
			long recordsTotal=mouventService.MouvementCountByWarehouse("", warehouseDTO);
			ResponseTable<MouvementDTO> response=new ResponseTable<MouvementDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
	

		@RequestMapping(value = "/correctStock", method = RequestMethod.POST)
		public String correction(@ModelAttribute("mouvement") @Valid MouvementDTO mouvementdto,BindingResult result, ModelMap model) {			
			if(result.hasErrors()){
				return "correctionStock";
			}
			initialize();
				ProductDTO productdto=new ProductDTO();
				productdto.setId(mouvementdto.getProduct().getId());
				WarehouseDTO warehousedto= new WarehouseDTO();
				warehousedto.setId(mouvementdto.getWarehouse().getId());
				int nombre=mouvementdto.getQuantity();
				String note=mouvementdto.getMotif();
				mouventService.correctStock(warehousedto, productdto, nombre, note, currentUser);
			
			return "redirect:/warehouse/profile?id="+warehousedto.getId();}
		
		@RequestMapping(value = "/transfertStock", method = RequestMethod.POST)
		public String transfertStock(@ModelAttribute("mouvement") @Valid MouvementDTO mouvementdto,BindingResult result, ModelMap model) {
			
			if(result.hasErrors()){
				return "transfertStock";
			}
			initialize();
			ProductDTO productdto= new ProductDTO();
			productdto.setId(mouvementdto.getProduct().getId());
			WarehouseDTO warehousedto= new WarehouseDTO();
			warehousedto.setId(mouvementdto.getWarehouse().getId());
			WarehouseDTO source= new WarehouseDTO();
			WarehouseDTO target=new WarehouseDTO();
			int nombre=mouvementdto.getQuantity();
			String note=mouvementdto.getMotif();
			mouventService.transfertStock(source, target, productdto, nombre, note, currentUser);
			return "redirect:/product/profile?id="+productdto.getId();}
		
		@RequestMapping(value = "/transfertStock", method = RequestMethod.GET)
		public String loadtransfertStock(@RequestParam long id, ModelMap model) {	 
			ProductDTO product=null;
			 MouvementDTO mouvement=new MouvementDTO();
			try {
				 product= productService.findProductById(id);
			} catch( ProductNotFoundException e) {
				 model.addAttribute("messageError","product how id="+id+"doesn't exist ");
				 return "error";
			}
			 if(product==null){
				 model.addAttribute("messageError","product how id="+id+"doesn't exist ");
				 return "error";
			 }
			ProductAssociatedDTO associatedProduct= new ProductAssociatedDTO();
			associatedProduct.setId(id);
			mouvement.setProduct(associatedProduct);
			List<WarehouseDTO>listWarehouse= warehouseService.getListWarehouse(0, 1000);
			 model.addAttribute("warehouseItems", listWarehouse);
				model.addAttribute("mouvement",mouvement);
			return "transfertStock";
			}
		
		
		@RequestMapping(value="/correctStock",method=RequestMethod.GET)
		 public String loadcorrectStockPage(@RequestParam long id, ModelMap model){
			 WarehouseDTO warehouse=null;
			 MouvementDTO mouvement=new MouvementDTO();
			try {
				 warehouse=warehouseService.findById(id);
			} catch( WarehouseNotFoundException e) {
				 model.addAttribute("messageError","warehouse how id="+id+"doesn't exist ");
				 return "error";
			}
			 if(warehouse==null){
				 model.addAttribute("messageError","ware how id="+id+"doesn't exist ");
				 return "error";
			 }
			WarehouseAssociatedDTO associatedWarehouse=new WarehouseAssociatedDTO();
			associatedWarehouse.setId(id);
			mouvement.setWarehouse(associatedWarehouse);  
			List<ProductDTO> listProduct=productService.getAllproduct(0,1000,"id asc","");
				model.addAttribute("productItems",listProduct);
				model.addAttribute("mouvement",mouvement);
			 return"correctionStock";
		 }
		@RequestMapping(value="/correctionProduit",method=RequestMethod.GET)
		public String loadCorrectStockProduct(@RequestParam long id, ModelMap model){
			ProductDTO product=null;
			 MouvementDTO mouvement=new MouvementDTO();
			try {
				 product=productService.findProductById(id);
			} catch( ProductNotFoundException e) {
				 model.addAttribute("messageError","product how id="+id+"doesn't exist ");
				 return "error";
			}
			 if(product==null){
				 model.addAttribute("messageError","product how id="+id+"doesn't exist ");
				 return "error";
			 }
			ProductAssociatedDTO associatedproduct= new ProductAssociatedDTO();
			associatedproduct.setId(id);
			mouvement.setProduct(associatedproduct); 
			List<WarehouseDTO>listWarehouse= warehouseService.getListWarehouse(0, 1000);
				model.addAttribute("warehouseItems",listWarehouse);
				model.addAttribute("mouvementSecond",mouvement);
			return "correctionStockOther";
		}
		@RequestMapping(value = "/correctionProduit", method = RequestMethod.POST)
		public String correctionStock(@ModelAttribute("mouvementSecond") @Valid MouvementDTO mouvementdto,BindingResult result, ModelMap model) {			
			if(result.hasErrors()){
				return "correctionStockOther";
			}
			initialize();
				ProductDTO productdto=new ProductDTO();
				productdto.setId(mouvementdto.getProduct().getId());
				WarehouseDTO warehousedto= new WarehouseDTO();
				warehousedto.setId(mouvementdto.getWarehouse().getId());
				int nombre=mouvementdto.getQuantity();
				String note=mouvementdto.getMotif();
				mouventService.correctStock(warehousedto, productdto, nombre, note, currentUser);
			
			return "redirect:/product/profile?id="+productdto.getId();}
		
			
}

