package ma.esoftech.esoftrade.controller;

import java.util.List;

import javax.validation.Valid;
import ma.esoftech.esoftrade.DTO.PosteCategoryDTO;
import ma.esoftech.esoftrade.DTO.PosteDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.exception.PosteNotFoundException;
import ma.esoftech.esoftrade.service.ICategoryPostService;
import ma.esoftech.esoftrade.service.IPosteService;
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
@RequestMapping("/categoryPost")
public class CategoryPoste extends AbstractController{
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/categoryPost/profile";
	@Autowired
	ICategoryPostService categoryService;
	@Autowired
	IPosteService posteService;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;

	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
public CategoryPoste() {
	// TODO Auto-generated constructor stub
}
	
	
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadCategory(@RequestParam long id, ModelMap model){
		PosteCategoryDTO category=null;
		try {
			
			category= categoryService.findById(id);
		} catch (PosteNotFoundException e) {
			model.addAttribute("messageError","category with id="+ id+"doesn't exist");
			return "error";
		}

        model.addAttribute("categoryPo", category);
		
		return "categoryPoProfile";
		}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute("categoryPo") @Valid PosteCategoryDTO category,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createCategoryP";
		} else {
            
			try {
				long id=categoryService.createCategory(category, currentUser);
				category.setId(id);
			} catch (Exception e) {
				result.rejectValue("name", "name.error.exist",
						"name exsist!!");
				return "createCategoryP";
			}
				return PATH_PROFIL+"?id="+category.getId();
			}
			
		}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadCategoryCreateForm(ModelMap model) {
		initialize();
		PosteCategoryDTO categorydto=new PosteCategoryDTO();
		model.addAttribute("categoryPo",categorydto );
		return "createCategoryP";
	}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeleteCategory(@RequestParam long id){
		 PosteCategoryDTO categorydto=new PosteCategoryDTO();
		categorydto.setId(id);
		categoryService.deleteCategory(categorydto);
		return "redirect:/categoryPost/list";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateCategory( @ModelAttribute("categoryPo") @Valid PosteCategoryDTO categorydto, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "createCategoryP";
		}
		initialize();
		try {
			categoryService.updateCategory(categorydto, currentUser);
		} catch (PosteNotFoundException e) {
			result.rejectValue("name", "name.error.exist",
					"name exsist!!");
			
			return "updateCategoryP";
		}
	
		 return PATH_PROFIL+"?id="+categorydto.getId();
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdateCategoryPage(@RequestParam long id, ModelMap model){
		PosteCategoryDTO categorydto=new PosteCategoryDTO();
		try {
			categorydto = categoryService.findById(id);
		} catch (PosteNotFoundException e) {
			e.printStackTrace();
		}
		 if(categorydto==null){
			 model.addAttribute("messageError","category how id="+id+"doesn't exist ");
			 return "error";
		 }
		 model.addAttribute("categoryPo",categorydto);
		 List<PosteCategoryDTO> listCategory=categoryService.getListCategory(0, 1000);
			model.addAttribute("categoryItems",listCategory);
		 return"updateCategoryP";
	 }
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadPostListProfil(ModelMap model){
		 
		 return "categoryListP";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<PosteCategoryDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<PosteCategoryDTO> list=categoryService.getListCategory(start, length, ordre.toString(), search);
			long recordsFiltered=categoryService.categoryCount(search);
			long recordsTotal=categoryService.categoryCount("");
			ResponseTable<PosteCategoryDTO> response=new ResponseTable<PosteCategoryDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/getListPost",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<PosteDTO> loadTables(@Valid RequestTable req,@RequestParam long id,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
            PosteCategoryDTO cat=new PosteCategoryDTO();
            cat.setId(id);
			List<PosteDTO> list=categoryService.getListPosteBycategory(start, length, ordre.toString(), search, cat);
			long recordsFiltered=categoryService.posteCountBycategory(search, cat);
			long recordsTotal=categoryService.posteCountBycategory("", cat);
			ResponseTable<PosteDTO> response=new ResponseTable<PosteDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
			return response;
		}
		@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody List<PosteCategoryDTO> searchCategories(@RequestParam String search,ModelMap model){
			
			return categoryService.searchPosteCategories(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
		}

		
}
