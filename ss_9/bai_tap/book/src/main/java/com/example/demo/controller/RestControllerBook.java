package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class RestControllerBook {
    @Autowired
    @Qualifier("bookService")
    private IBookService iBookService;
    @GetMapping(value = "/list123")
    public Page<Book> showList(Model model, @RequestParam(value = "page",defaultValue = "0") int page){
        Sort sort = Sort.by("namebook").descending();
       return  iBookService.getAll(PageRequest.of(page,1,sort));
    }
    @GetMapping(value = "/detail/{id}")
    public String detailBook(Model model, @PathVariable(value = "id")int id){
        model.addAttribute("detailBook",iBookService.detailBook(id));
        return "detailBook";
    }
    @PostMapping(value = "/")
    public Book createBook(@RequestBody Book book){
        book.setRandomNumber(iBookService.ranNumber());
            return iBookService.save(book);
    }
}
