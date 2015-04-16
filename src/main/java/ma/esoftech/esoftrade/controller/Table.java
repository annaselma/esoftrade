package ma.esoftech.esoftrade.controller;

import javax.validation.Valid;

import ma.esoftech.esoftrade.datatablesAPI.RequestTable;
import ma.esoftech.esoftrade.datatablesAPI.ResponseTable;
import ma.esoftech.esoftrade.generate.Entity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/table")
public class Table {
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String table(ModelMap model){
	return "hello";
	}
	
	@RequestMapping(value="/getList",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody ResponseTable<Entity> loadTables(@Valid RequestTable req,BindingResult bindingResult,ModelMap model){
		if(bindingResult.hasErrors()){
			return null;
		}
		System.out.println(req.getLength());
		ResponseTable<Entity> response=new ResponseTable<Entity>();
		System.out.println(req.getColumns().size());
		return response;
	}
	
	

}
