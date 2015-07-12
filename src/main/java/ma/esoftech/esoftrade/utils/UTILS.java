package ma.esoftech.esoftrade.utils;

import org.springframework.ui.ModelMap;

public class UTILS {

	public static final int MAX_LENGHT_LIST=1000;
	public static final int START_LIST=0;
	public static final String  FORMAT_DATE="dd/MM/yyyy";
	public  static void prepareExpeditionProfil(ModelMap model,boolean exp){
		if(exp){
			model.addAttribute("defaultActive","");
			model.addAttribute("expActive","active");
			model.addAttribute("defaultIn","");
			model.addAttribute("expIn","in");
		}else{
			model.addAttribute("defaultActive","active");
			model.addAttribute("expActive","");
			model.addAttribute("defaultIn","in");
			model.addAttribute("expIn","");
		}
	}
}
