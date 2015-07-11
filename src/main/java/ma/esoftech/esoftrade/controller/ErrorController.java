package ma.esoftech.esoftrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/error")
public class ErrorController extends AbstractController {
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String get403page(ModelMap model){
		return"403";
	}
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String get404page(ModelMap model){
		return"404";
	}

}