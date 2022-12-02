package controller.controllers;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import com.sun.org.apache.xpath.internal.operations.Mod;
import controller.model.Product;
import controller.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ControllerService {
    @Autowired
    @Qualifier("productService")
    private IProductService iProductService;
    @GetMapping("/")
    public String showList(Model model){
        model.addAttribute("listProduct",iProductService.getAll());
        return "list";
    }
    @GetMapping("/create")
    public String createProduct(Model model){
        model.addAttribute("product", new Product(0, "",0.0,""));
        return "create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Product product, Model model, RedirectAttributes redirectAttributes){
        iProductService.save(product);
        List<Product> products= iProductService.getAll();
        model.addAttribute("listProduct",products);
        redirectAttributes.addFlashAttribute("msg","them moi thanh cong");
        return "redirect:/list";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){
    model.addAttribute("product",iProductService.getStudentByBName(id));
    return "detail";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model){
        iProductService.delete(id);
        model.addAttribute("listProduct",iProductService.getAll());
        return "list";
    }
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("listProduct",iProductService.getAll());
        return "list";
    }
    @GetMapping("/search")
    public String search(@RequestParam(defaultValue = "") String nameSearch ,Model model){
        model.addAttribute("listProduct",iProductService.search(nameSearch));
        return "list";
    }
}
