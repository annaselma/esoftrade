package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.PCategoryDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.exception.PCatNotFoundException;
import ma.esoftech.esoftrade.exception.ProductNotFoundException;
import ma.esoftech.esoftrade.model.Product;
import ma.esoftech.esoftrade.model.ProductCategory;
import ma.esoftech.esoftrade.service.ICategoryProduct;

import org.jboss.logging.Param;
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
@RequestMapping("/category")
public class CategoryProductController extends AbstractController {
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/category/profile";
	@Autowired
	ICategoryProduct categoryService;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;

	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
	
public CategoryProductController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadCategory(@RequestParam long id, ModelMap model){
		PCategoryDTO category=null;
		try {
			
			category= categoryService.findById(id);
		} catch (PCatNotFoundException e) {
			model.addAttribute("messageError","cateory with id="+ id+"doesn't exist");
			return "error";
		}

        model.addAttribute("category", category);
		
		return "categoryProfile";
		}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") @Valid PCategoryDTO category,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createCategory";
		} else {
            
			try {
				long id=categoryService.createCategory(category, currentUser);
				category.setId(id);
			} catch (Exception e) {
				result.rejectValue("name", "name.error.exist",
						"name exsist!!");
				return "createCategory";
			}
				return PATH_PROFIL+"?id="+category.getId();
			}
			
		}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadCategoryCreateForm(ModelMap model) {
		initialize();
		PCategoryDTO categorydto= new PCategoryDTO();
		model.addAttribute("category",categorydto );
		return "createCategory";
	}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteCategory(@RequestParam long id){
		 PCategoryDTO categorydto= new PCategoryDTO();
		categorydto.setId(id);
		categoryService.deleteCategory(categorydto);
		return "redirect:/category/list";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateCategory( @ModelAttribute("category") @Valid PCategoryDTO categorydto, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "createCategory";
		}
		initialize();
		try {
			categoryService.updateCategory(categorydto, currentUser);
		} catch (PCatNotFoundException e) {
			result.rejectValue("name", "name.error.exist",
					"name exsist!!");
			
			return "updateCategory";
		}
	
		 return PATH_PROFIL+"?id="+categorydto.getId();
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateCategoryPage(@RequestParam long id, ModelMap model){
		 PCategoryDTO categorydto=null;
		try {
			categorydto = categoryService.findById(id);
		} catch (PCatNotFoundException e) {
			e.printStackTrace();
		}
		 if(categorydto==null){
			 model.addAttribute("messageError","category how id="+id+"doesn't exist ");
			 return "error";
		 }
		 model.addAttribute("category",categorydto);
		 List<PCategoryDTO> listCategory=categoryService.getListCategory(0, 1000);
			model.addAttribute("categoryItems",listCategory);
		 return"updateProduct";
	 }
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadProductListProfil(ModelMap model){
		 
		 return "categoryList";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<PCategoryDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<PCategoryDTO> list=categoryService.getListCategory(start, length, ordre.toString(), search);
			long recordsFiltered=categoryService.categoryCount(search);
			long recordsTotal=categoryService.categoryCount("");
			ResponseTable<PCategoryDTO> response=new ResponseTable<PCategoryDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/getListProduct",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<ProductDTO> loadTables(@Valid RequestTable req,@RequestParam long id,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
            PCategoryDTO cat=new PCategoryDTO();
            cat.setId(id);
			List<ProductDTO> list=categoryService.getListProductBycategory(length, start,ordre.toString(), search, cat);
			long recordsFiltered=categoryService.productCountBycategory(search, cat);
			long recordsTotal=categoryService.productCountBycategory("",cat);
			ResponseTable<ProductDTO> response=new ResponseTable<ProductDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody List<PCategoryDTO> searchCategories(@RequestParam String search,ModelMap model){
			return categoryService.searchProductCategories(1000,0, search);
		}

		

}
