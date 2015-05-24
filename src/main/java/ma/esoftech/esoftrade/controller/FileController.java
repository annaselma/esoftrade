package ma.esoftech.esoftrade.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import ma.esoftech.esoftrade.DTO.FileDTO;
import ma.esoftech.esoftrade.DTO.ProductDTO;
import ma.esoftech.esoftrade.DTO.UserDTO;
import ma.esoftech.esoftrade.controller.session.SessionBean;
import ma.esoftech.esoftrade.datatablesAPI.Order;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.RequestTable.SearchCriterias;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.exception.FileNotFoundException;
import ma.esoftech.esoftrade.service.IFileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("file")
public class FileController extends AbstractController{
	
	@Autowired
	ServletContext servletContext;
	@Autowired
	IFileService fileService;
	@Autowired
	SessionBean sessionBean;
	UserDTO currentUser;

	
	protected void initialize() {
		this.currentUser = sessionBean.getUserDTO();
	}
	@RequestMapping(method = RequestMethod.GET)
	public void getFileById(HttpServletResponse response,@RequestParam long id){
	    try {
			fileService.getFileFromDisk(response, id);
		} catch (IOException | FileNotFoundException e) {
		}
		
	}
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<FileDTO> loadTables(@Valid RequestTable req,BindingResult bindingResult,@RequestParam long id, 
			@RequestParam String module,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		Order ordre=Order.createOrderFromRequestTable(req);
		String search=req.getSearch().get(SearchCriterias.value);
		ordre.toString();
		int start=req.getStart();
		int  length=req.getLength();
		int draw=req.getDraw();
		List<FileDTO> list=fileService.getFileList(start, length, ordre.toString(), module, id);
		long recordsFiltered=fileService.countFile(module, id);
		long recordsTotal=recordsFiltered;
		ResponseTable<FileDTO> response=new ResponseTable<FileDTO>();
		response.setDraw(draw);
		response.setRecordsFiltered(recordsFiltered);
		response.setRecordsTotal(recordsTotal);
		response.setData(list);
		return response;
	}


}
