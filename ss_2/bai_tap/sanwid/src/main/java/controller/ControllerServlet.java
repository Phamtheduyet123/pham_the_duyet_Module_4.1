package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerServlet {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment" ,defaultValue = "null") String[] condiment , Model model) {
        String char1 ="";
        for (int i = 0; i < condiment.length; i++) {
            char1+=" "+condiment[i];
        }
            model.addAttribute("condiment", char1);
        return "index";
    }
}
