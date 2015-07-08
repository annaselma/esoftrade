package ma.esoftech.esoftrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping("/demo")
public class InstallationTest {
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	
	public String loadInstall(ModelMap model){
		model.addAttribute("tiers", "Information");
		return "test";
	}
	public InstallationTest() {
		// TODO Auto-generated constructor stub
	}
}
