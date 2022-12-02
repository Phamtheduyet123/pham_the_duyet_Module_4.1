package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerServlet {
    Double result;

    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("/hello")
    public String submit(@RequestParam String q,
                         @RequestParam Double p,
                         @RequestParam Double p1, Model model) {
        switch (q) {
            case "Addition":
                result = p + p1;
                break;
            case "Subtraction":
                result = p - p1;
                break;
            case "Multiplication":
                result = p * p1;
                break;
            case "Division":
                result = p / p1;
                break;
            default: result= 0.0;

        }
        model.addAttribute("result", result);
        return "index";
    }

}
