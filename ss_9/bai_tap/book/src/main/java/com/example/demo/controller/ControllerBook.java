package com.example.demo.controller;

import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ControllerBook {
    @Autowired
    @Qualifier("bookService")
    private IBookService iBookService;
    @GetMapping(value = "/list123")
    public String showList(Model model,@RequestParam(value = "page",defaultValue = "0") int page){
        Sort sort = Sort.by("namebook").descending();
        model.addAttribute("listBook",iBookService.getAll(PageRequest.of(page,1,sort)));
        return "list";
    }
    @GetMapping(value = "/detail/{id}")
    public String detailBook(Model model, @PathVariable(value = "id")int id){
        model.addAttribute("detailBook",iBookService.detailBook(id));
        return "detailBook";
    }
    @GetMapping(value = "/order/{id}")
    public String orderBook(@PathVariable(value = "id")int id,Model model){
        if(iBookService.orderBook(id)){
            model.addAttribute("msg",iBookService.getRandomNumber(id));
        }
        else {
            model.addAttribute("msg","Khong con sach de muon");
        }
        return "detailBook";
    }
}


