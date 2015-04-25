package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.DTO.PasswordDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.exeption.ProductNotFoundException;
import ma.esoftech.esoftrade.exeption.UserNameException;
import ma.esoftech.esoftrade.exeption.UserNotFoundException;
import ma.esoftech.esoftrade.service.ICategoryProduct;
import ma.esoftech.esoftrade.service.IProductService;

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

@Controller
@RequestMapping("/product")
public class ProductController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/product/productProfile";
	@Autowired
	IProductService productService;
	@Autowired
	ICategoryProduct categoryService;
	@Autowired
   SessionBean sessionBean;
	 
	UserDTO currentUser;
	
	public ProductController() {
	}
	private void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String loadProduct(@RequestParam long id, ModelMap model){
		ProductDTO product=null;
		try {
			
			product= productService.findProductById(id);
		} catch (ProductNotFoundException e) {
			model.addAttribute("messageError","product with id="+ id+"doesn't exist");
			return "error";
		}

        model.addAttribute("product", product);
		
		return "productProfile";
		}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") @Valid ProductDTO product,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createProduct";
		} else {
            
				long id=productService.createProduct(product, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadProductCreateForm(ModelMap model) {
		initialize();
		List<PCategoryDTO> listCategory=categoryService.getListCtagory(0, 1000);
		model.addAttribute("categoryItems",listCategory);
		ProductDTO productdto= new ProductDTO();
		model.addAttribute("product", productdto);
		return "createProduct";
	}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteProduct(@RequestParam long id){
		 ProductDTO productdto= new ProductDTO();
		productdto.setId(id);
		productService.deleteProduct(productdto);
		return "redirect:/product/list";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateProduct( @ModelAttribute("product") @Valid ProductDTO product, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "createProduct";
		}
		initialize();
		try {
			productService.updateProduct(product, currentUser);
		} catch (ProductNotFoundException e) {
			model.addAttribute("messageError","user how id="+product.getId()+"doesn't exist");
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+product.getId();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateProductPage(@RequestParam long id, ModelMap model){
		 ProductDTO product=null;
		try {
			product = productService.findProductById(id);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		 if(product==null){
			 model.addAttribute("messageError","product how id="+id+"doesn't exist ");
			 return "error";
		 }
		 model.addAttribute("product",product);
		 List<PCategoryDTO> listCategory=categoryService.getListCtagory(0, 1000);
			model.addAttribute("categoryItems",listCategory);
		 return"updateProduct";
	 }
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadProductListProfil(ModelMap model){
		 
		 return "productList";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<ProductDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<ProductDTO> list=productService.getAllproduct(start, length, ordre.toString(), search);
			long recordsFiltered=productService.productCount(search);
			long recordsTotal=productService.productCount("");
			ResponseTable<ProductDTO> response=new ResponseTable<ProductDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}

	}