package ma.esoftech.esoftrade.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ma.esoftech.esoftrade.model.Person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SpringTilesController {
 
    @RequestMapping(value="index")
    public String index() {
        return "index";
    }
    
    @RequestMapping(value="viewPeson")
    public ModelAndView viewPersons(Model model) {
        Map<String, List<Person>> persons =
                new HashMap<String, List<Person>>();
        persons.put("persons", Person.createPersons());
        return new ModelAndView("personList", persons);
    }
    
}