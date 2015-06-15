package ma.esoftech.esoftrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadDash(ModelMap model){
		model.addAttribute("saymon", model);
		return "dashboard";
	}

}
