package ma.esoftech.esoftrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.OrderDTO;
import ma.esoftech.esoftrade.DTO.OrderExpedition;
import ma.esoftech.esoftrade.DTO.OrderExpeditionList;
import ma.esoftech.esoftrade.DTO.OrderLineDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.DTO.associated.OrderAssociatedDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.OrderNotFoundException;
import ma.esoftech.esoftrade.exception.OrderUpdateException;
import ma.esoftech.esoftrade.model.OrderDocument.OrderStatus;
import ma.esoftech.esoftrade.model.OrderDocument.OrderType;
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.IMouvementService;
import ma.esoftech.esoftrade.service.IOrderService;
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
@RequestMapping("/order")
public class OrderController extends AbstractController {
	private static final String REDIRECT = "redirect:";
	private static final String PATH_PROFIL = REDIRECT + "/order/profile";
	@Autowired
	IOrderService orderService;
	@Autowired
	IFileService fileService;
	@Autowired
	IMouvementService mouvementService;
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
			@RequestParam(required = false, defaultValue = "false") boolean file,
			@RequestParam(required = false, defaultValue = "false") boolean exp) {
		return loadCustomazingProfilePage(id, new OrderLineDTO(), model, file,builExpeditionList(id),exp);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String loadAddPage(@RequestParam OrderType type,ModelMap model){
		OrderDTO order=new OrderDTO();
		order.setStatus(OrderStatus.draft);
		model.addAttribute("order",order);
	   return getReturnCreatePage(type, order);
	}
	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addOrder(@ModelAttribute("order") @Valid OrderDTO order,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return getReturnCreatePage(order.getType(), order);
		} else {
			    order.setStatus(OrderStatus.draft);
				long id=orderService.createOrder(order, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String loadupdatePage(@RequestParam long id,ModelMap model){
		OrderDTO order=null;
		try {
			order=orderService.findById(id);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		if(order.getStatus()!=OrderStatus.draft){
			return PATH_PROFIL+"?id="+order.getId();
		}
		model.addAttribute("order",order);
		return getReturnUpdatePage(order.getType(), order);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOrder(@ModelAttribute("order") @Valid OrderDTO order,
			BindingResult result,ModelMap model) {
		initialize();
		if (result.hasErrors()) {
			return getReturnUpdatePage(order.getType(), order);
		} else {
            
				try {
					orderService.updateOrder(order, currentUser);
				} catch (OrderNotFoundException e) {
					model.addAttribute("messageError",e.getMessage());
					return "error";
				}catch(OrderUpdateException e){
					return PATH_PROFIL+"?id="+order.getId();
				}
				return PATH_PROFIL+"?id="+order.getId();
			}
			
		}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteOrder(@RequestParam long id,@RequestParam OrderType type,ModelMap model){
		OrderDTO order=new OrderDTO();
		order.setId(id);
		try {
			orderService.deleteOrder(order);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
			return "redirect:/order/list?type="+type;
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadListProfil(@RequestParam(defaultValue="all") OrderType type,ModelMap model){
		 switch(type){
		case customerOrder:
			return "customerOrderList";
		case supplierOrder:
			return "supplierOrderList";
		default:
			return "customerOrderList";
		
		 }
	 }
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<OrderDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,@RequestParam(value="type")OrderType type,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		Order ordre=Order.createOrderFromRequestTable(req);
		String search=req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start=req.getStart();
		int  length=req.getLength();
		int draw=req.getDraw();
		List<OrderDTO> orders=null;
		long recordsFiltered=0,recordsTotal=0;
		switch(type){
		case customerOrder:
			orders=orderService.getCustomerOrders(start, length, ordre.toString(),search);
			recordsFiltered=orderService.customerOrdersCount(search);
			recordsTotal=orderService.customerOrdersCount("");
			break;
		case supplierOrder:
			orders=orderService.getSupplierOrders(start, length, ordre.toString(),search);
			recordsFiltered=orderService.supplierOrdersCount(search);
			recordsTotal=orderService.supplierOrdersCount("");
			break;
		default:
			orders=orderService.getCustomerOrders(start, length, ordre.toString(),search);
			recordsFiltered=orderService.customerOrdersCount(search);
			recordsTotal=orderService.customerOrdersCount("");
			break;
		
		}
		ResponseTable<OrderDTO> response=new ResponseTable<OrderDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(orders);
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
			
			orderService.attachFileToOrder(fileDTO, id, currentUser);
		} catch (IOException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		 return PATH_PROFIL+"?id="+id+"&file=true";
	}
	@RequestMapping(value="/detachFile",method=RequestMethod.GET)
	public String detachFile(@RequestParam(value = "id")long id,@RequestParam(value="file_id")long fileId,ModelMap model){
		initialize();
		
		FileDTO file=new FileDTO();
		file.setId(fileId);
		try {
			orderService.dettachFileFromOrder(file, id, currentUser);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		return PATH_PROFIL+"?id="+id+"&file=true";
	}
	@RequestMapping(value="/addOrderLine",method=RequestMethod.POST)
	public String addOrderLine(@ModelAttribute("orderLine") @Valid OrderLineDTO orderLine,
			BindingResult result, @RequestParam(value="order_id") long id,ModelMap model){
		initialize();
		if (result.hasErrors()) {
			return loadCustomazingProfilePage(id, orderLine, model, false,builExpeditionList(id),false);
		} else {
			OrderDTO order=new OrderDTO();
			order.setId(id);
            try {
				orderService.addRowToOrder(orderLine, order, currentUser);
			} catch (OrderNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
		}
		return PATH_PROFIL+"?id="+id;
	}
	@RequestMapping(value="/export",method=RequestMethod.POST)
	public String export(@ModelAttribute("expedition") @Valid OrderExpeditionList expedition,
			BindingResult result,ModelMap model){
		initialize();
		if (result.hasErrors()) {
			return loadCustomazingProfilePage(expedition.getOrder().getId(),new OrderLineDTO(), model,false,
					builExpeditionList(expedition.getOrder().getId()),true);
		} else {
			
         mouvementService.delivryStockfromOrder(expedition, currentUser);
		}
		return PATH_PROFIL+"?id="+expedition.getOrder().getId()+"&exp=true";
	}
	@RequestMapping(value="/import",method=RequestMethod.POST)
	public String importStock(@ModelAttribute("expedition") @Valid OrderExpeditionList expedition,
			BindingResult result,ModelMap model){
		initialize();
		if (result.hasErrors()) {
			return loadCustomazingProfilePage(expedition.getOrder().getId(),new OrderLineDTO(), model,false,
					builExpeditionList(expedition.getOrder().getId()),true);
		} else {
			
         mouvementService.importStockfromOrder(expedition, currentUser);
		}
		return PATH_PROFIL+"?id="+expedition.getOrder().getId()+"&exp=true";
	}
	@RequestMapping(value="/detachOrderLine",method=RequestMethod.GET)
	public String detachOrderLine(@RequestParam long id, @RequestParam(value="order_id") long idOrder,ModelMap model){
		initialize();
		
		OrderDTO order=new OrderDTO();
		order.setId(idOrder);
		OrderLineDTO orderLine=new OrderLineDTO();
		orderLine.setId(id);
            try {
				orderService.deleteRowFromOrder(orderLine, order, currentUser);
			} catch (OrderNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
		return PATH_PROFIL+"?id="+idOrder;
	}
	
	
	@RequestMapping(value="/draft",method=RequestMethod.GET)
	public String draft(@RequestParam long id,ModelMap model){
		OrderDTO order=null;
		initialize();
		try {
			order=orderService.findById(id);
			order.setStatus(OrderStatus.draft);
			orderService.updateOrder(order, currentUser);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (OrderUpdateException e) {
			return PATH_PROFIL+"?id="+id;
		}
		
		return PATH_PROFIL+"?id="+id;
	}
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String save(@RequestParam long id,ModelMap model){
		OrderDTO order=null;
		initialize();
		try {
			order=orderService.findById(id);
			order.setStatus(OrderStatus.sentOrSaved);
			orderService.updateOrder(order, currentUser);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (OrderUpdateException e) {
			return PATH_PROFIL+"?id="+id;
		}
		return PATH_PROFIL+"?id="+id;
	}
	@RequestMapping(value="/billed",method=RequestMethod.GET)
	public String billed(@RequestParam long id,ModelMap model){
		OrderDTO order=null;
		initialize();
		try {
			order=orderService.findById(id);
			order.setStatus(OrderStatus.billed);
			orderService.updateOrder(order, currentUser);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (OrderUpdateException e) {
			return PATH_PROFIL+"?id="+id;
		}
		return PATH_PROFIL+"?id="+id;
	}
	@RequestMapping(value="/delivred",method=RequestMethod.GET)
	public String delivred(@RequestParam long id,ModelMap model){
		OrderDTO order=null;
		initialize();
		try {
			order=orderService.findById(id);
			order.setStatus(OrderStatus.delivred);
			orderService.updateOrder(order, currentUser);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (OrderUpdateException e) {
			return PATH_PROFIL+"?id="+id;
		}
		
		return PATH_PROFIL+"?id="+id;
	}
	@RequestMapping(value="/denied",method=RequestMethod.GET)
	public String denied(@RequestParam long id,ModelMap model){
		OrderDTO order=null;
		initialize();
		try {
			order=orderService.findById(id);
			order.setStatus(OrderStatus.denied);
			orderService.updateOrder(order, currentUser);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		} catch (OrderUpdateException e) {
			return PATH_PROFIL+"?id="+id;
		}
		
		return PATH_PROFIL+"?id="+id;
	}
	private String loadCustomazingProfilePage(long id,OrderLineDTO orderLine,ModelMap model,boolean file,OrderExpeditionList exp,boolean expProfile){
		OrderDTO order=null;
		try {
			order=orderService.findById(id);
		} catch (OrderNotFoundException e) {
			model.addAttribute("messageError",e.getMessage());
			return "error";
		}
		FileUploadUTILS.prepareTabProfil(model, file);
		if(expProfile){
		UTILS.prepareExpeditionProfil(model, expProfile);
		
		}
		model.addAttribute("order", order);
		model.addAttribute("expedition", exp);
		model.addAttribute("orderLine",orderLine);
		switch(order.getType()){
		case customerOrder:
			return "customerOrderProfile";
		case supplierOrder:
			return "supplierOrderProfile";
		default:
			return "customerOrderProfile";
		}
	}
	private String getReturnUpdatePage(OrderType type,OrderDTO order){
		switch(type){
		case customerOrder:
			order.setType(OrderType.customerOrder);
			return "updateCustomerOrder";
		case supplierOrder:
			order.setType(OrderType.supplierOrder);
			return "updateSupplierOrder";
		default:
			order.setType(OrderType.customerOrder);
			return "updateCustomerOrder";
		
		}
}
	private String getReturnCreatePage(OrderType type,OrderDTO order){
		switch(type){
		case customerOrder:
			order.setType(OrderType.customerOrder);
			return "createCustomerOrder";
		case supplierOrder:
			order.setType(OrderType.supplierOrder);
			return "createSupplierOrder";
		default:
			order.setType(OrderType.customerOrder);
			return "createCustomerOrder";
		
		}
	}
	private OrderExpeditionList builExpeditionList(long id){
		OrderExpeditionList orderExpedition=new OrderExpeditionList();
		try {
			OrderDTO order=orderService.findById(id);
			OrderExpedition exp=null;
			OrderAssociatedDTO o=new  OrderAssociatedDTO();
			o.setId(order.getId());
			orderExpedition.setOrder(o);
			for(OrderLineDTO orderLiDto :order.getLines()){
				exp=new OrderExpedition();
				if(orderLiDto.getProduct()==null){
					continue;
				}
				System.out.println("produiiit"+orderLiDto.getProduct().getId());
				exp.setPrice((float)orderLiDto.getUnitPrice());
			    exp.setQte(orderLiDto.getQuantity());
			    exp.setProduct(orderLiDto.getProduct());
			    orderExpedition.getExpeditions().add(exp);
			}
		} catch (OrderNotFoundException e) {
			return null;
		}
		return orderExpedition;
	}
}
