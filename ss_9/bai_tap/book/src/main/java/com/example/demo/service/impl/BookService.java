package com.example.demo.service.impl;

import com.example.demo.model.Book;
import com.example.demo.reponsitory.IBookReponsitory;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service("bookService")
public class BookService implements IBookService {
    @Autowired
    private IBookReponsitory iBookReponsitory;
    public Integer ranNumber(){
        Integer value = (int) Math.floor(Math.random()*100000)-1;
        return value;
    }
    @Override
    public List<Book> findAll() {
        return iBookReponsitory.findAll();
    }

    @Override
    public boolean orderBook(Integer id) {
       Optional<Book> book = iBookReponsitory.findById(id);
        Book book1 = book.get();
        if(book1.getNumber()==0){
            return  false;
        }
        else {
            book1.setNumber(book1.getNumber() - 1);
           iBookReponsitory.save(book1);
        }
        return true;
    }

    @Override
    public Book detailBook(Integer id) {
        Optional<Book> bookList =iBookReponsitory.findById(id);
//        if(bookList.isPresent()){
//            bookList.get();
//        }
//        else {
//            return null;
//        }
        return iBookReponsitory.findById(id).orElse(null);
    }

    @Override
    public Book save(Book book) {
        return iBookReponsitory.save(book);
    }

    @Override
    public int getRandomNumber(Integer id) {
        Optional<Book> book =iBookReponsitory.findById(id);
        Book book1 = book.get();
       return book1.getRandomNumber();
    }

    void muonsach(int id){
       Optional<Book> book=  iBookReponsitory.findById(id);
       if(book.isPresent()){
           Book book1 = book.get();
           book1.setNumber(book1.getNumber() - 1);
           iBookReponsitory.save(book1);
       }

    }

    @Override
    public boolean returnBook(Integer number) {
        return false;
    }

    @Override
    public Page getAll(Pageable pageable) {
        return iBookReponsitory.findAll(pageable);
    }
}


