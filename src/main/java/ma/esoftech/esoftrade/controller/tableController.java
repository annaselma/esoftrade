package ma.esoftech.esoftrade.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/tables")
public class tableController {

	
	@RequestMapping(method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody String loadTables(@ModelAttribute RequestTable req,ModelMap model){
		
		
//			for(Entry<String, String> entry :map.entrySet()){
//				System.out.println( entry.getKey());
//				System.out.println(entry.getValue());
//				System.out.println("--end story---");
//			}
//		
//		
//		for (String string : list) {
//			System.out.println(string);
//		}
//		
		//System.out.println(((RequestTable)model.get("req")).getName());
		
		return "hello"+req.getName();
	}
	
	/*@ModelAttribute(value="req")*/
	public RequestTable getRequest(){
		RequestTable req=new RequestTable();
		req.setAge("30");
		req.setName("toto");
		return req;
	}
}
