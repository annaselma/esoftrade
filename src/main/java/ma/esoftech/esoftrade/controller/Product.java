package ma.esoftech.esoftrade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/produit")

public class Product {
	@RequestMapping(method = RequestMethod.GET)
	public String afficher(ModelMap model){
		model.addAttribute("prod", "Information");
		
		return "produit";}
	
}
