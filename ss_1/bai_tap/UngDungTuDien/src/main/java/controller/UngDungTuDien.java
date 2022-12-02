package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class UngDungTuDien {
    String result="";
   String[] a = {"hello","goobye","watch movie"};
   String[] b = {"xin chao","tam biet","xem phim"};
    @GetMapping("")
    public String UngDung(){
        return "index";
    }
    @GetMapping("/ChuyenDoi")
    public String chuyenDoi(@RequestParam String character, Model model){
        for (int i = 0; i <a.length ; i++) {
            if (character.equals(a[i])){
                result = b[i];
                break;
            }
            else {
                result="not found";
            }
        }
        model.addAttribute("TuDien",result);
        return "index";
    }
}
