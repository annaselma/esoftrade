package ma.esoftech.esoftrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/table")
public class Table {
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String table(ModelMap model){
	return "hello";
	}
	

}
