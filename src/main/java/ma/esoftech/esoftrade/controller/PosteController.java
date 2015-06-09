package ma.esoftech.esoftrade.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
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
import ma.esoftech.esoftrade.service.IFileService;
import ma.esoftech.esoftrade.service.IPosteService;
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
@RequestMapping("/poste")
public class PosteController extends AbstractController{
	private static final String REDIRECT="redirect:";
	private static final String PATH_PROFIL=REDIRECT+"/poste/profile";
	@Autowired
	IPosteService posteService;
	@Autowired
	ICategoryPostService catService;
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
	public PosteController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String loadPoste(@RequestParam long id, ModelMap model,@RequestParam(required=false,defaultValue="false") boolean file){
		PosteDTO poste=null;
		try {
			
			poste=posteService.findPosteById(id);
		} catch (PosteNotFoundException e) {
			model.addAttribute("messageError","post with id="+ id+"doesn't exist");
			return "error";
		}
		FileUploadUTILS.prepareTabProfil(model, file);
        model.addAttribute("poste", poste);
		
		return "postProfile";
		}
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("poste") @Valid PosteDTO poste,
			BindingResult result) {
		initialize();
		if (result.hasErrors()) {
			return "createPost";
		} else {
            
				long id=posteService.createPoste(poste, currentUser);
				return PATH_PROFIL+"?id="+id;
			}
			
		}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String loadPostCreateForm(ModelMap model) {
		initialize();
		PosteDTO postedto= new PosteDTO();
		model.addAttribute("poste", postedto);
		return "createPost";
	}
	@RequestMapping(value="/delete",method= RequestMethod.GET)
	public String DeletePost(@RequestParam long id){
		PosteDTO postedto= new PosteDTO();
		postedto.setId(id);
		posteService.deletePoste(postedto);
		return "redirect:/poste/list";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePost( @ModelAttribute("post") @Valid PosteDTO poste, BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "updatePost";
		}
		initialize();
		try {
			posteService.updatePoste(poste, currentUser);
		} catch (PosteNotFoundException e) {
			model.addAttribute("messageError","post how id="+poste.getId()+"doesn't exist");
			return "error";
		}
	
		 return PATH_PROFIL+"?id="+poste.getId();
	}
	

	@RequestMapping(value="/update",method=RequestMethod.GET)
	 public String loadUpdatePostPage(@RequestParam long id, ModelMap model){
		 PosteDTO poste=null;
		try {
			poste=posteService.findPosteById(id);
		} catch (PosteNotFoundException e) {
			e.printStackTrace();
		}
		 if(poste==null){
			 model.addAttribute("messageError","poste how id="+id+"doesn't exist ");
			 return "error";
		 }
		 model.addAttribute("poste",poste);
		
		 return"updatePost";
	 }
	@RequestMapping(value="/list",method=RequestMethod.GET)
	 public String loadPostListProfil(ModelMap model){
		 
		 return "postList";
	 }
		@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody ResponseTable<PosteDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
			if(bindingResult.hasErrors()){
				return null;
			}
			Order ordre=Order.createOrderFromRequestTable(req);
			String search=req.getSearch().get(SearchCriterias.value);
			ordre.toString();
			int start=req.getStart();
			int  length=req.getLength();
			int draw=req.getDraw();
			List<PosteDTO> list=posteService.getAllPoste(start, length, ordre.toString(), search);
			long recordsFiltered=posteService.PosteCount(search);
			long recordsTotal=posteService.PosteCount("");
			ResponseTable<PosteDTO> response=new ResponseTable<PosteDTO>();
			response.setDraw(draw);
			response.setRecordsFiltered(recordsFiltered);
			response.setRecordsTotal(recordsTotal);
			response.setData(list);
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
				
				posteService.attachFileToPoste(fileDTO, id, currentUser);
			} catch (IOException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			} catch (PosteNotFoundException e) {
				model.addAttribute("messageError",e.getMessage());
				return "error";
			}
			 return PATH_PROFIL+"?id="+id+"&file=true";
		}
		@RequestMapping(value="/search",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody List<PosteDTO> searchPost(@RequestParam String search,ModelMap model){
			return  posteService.searchPoste(UTILS.MAX_LENGHT_LIST,UTILS.START_LIST, search);
		}
		
		
		@ModelAttribute("categoryItems")
		public List<PosteCategoryDTO> getCategoryList(){
			List<PosteCategoryDTO> listCategory=catService.getListCategory(0, 1000);
			return listCategory;
		}
}
		