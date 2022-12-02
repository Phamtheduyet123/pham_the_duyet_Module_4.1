package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChuyenDoiTienTe {
    double money;
    @GetMapping("")
    public  String ungDung(){
        return "index";
    }
    @PostMapping("/USD")
    public String DoiTien(@RequestParam String USD, Model model){
        money=Double.parseDouble(USD)*23000;
        model.addAttribute("money",money);
        return "index";
    }
}
