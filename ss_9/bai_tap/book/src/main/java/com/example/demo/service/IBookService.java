package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Integer ranNumber();
    boolean orderBook(Integer id);
    Book detailBook(Integer id);
    Book save(Book book);
    int getRandomNumber(Integer id);
    boolean returnBook(Integer number);
    Page getAll(Pageable pageable);

}
