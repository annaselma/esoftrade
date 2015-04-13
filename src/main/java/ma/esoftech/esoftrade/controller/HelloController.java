package ma.esoftech.esoftrade.controller;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/profile")
public class HelloController{
	final static Logger logger = Logger.getLogger(HelloController.class);
   @RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model) {
//String str="eee";
//
//
//	 logger.info("this is message");
//	 logger.debug("this is for dev");
//      model.addAttribute("message", "Hello Spring MVC Framework!");
      model.addAttribute("fourn", "ui");
      return "profile";
   }

}
