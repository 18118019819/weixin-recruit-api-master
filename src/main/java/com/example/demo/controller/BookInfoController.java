package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BookInfo")
public class BookInfoController {

    @Autowired
    private BookMapper bookMapper;


    @GetMapping("/InsertBookInfo")
    public int InsertBookInfo(Book book){
        return bookMapper.BookInsert(book);
    }

    @GetMapping("/DeleteBookInfo")
    public int DeleteBookInfo(Integer bookId){
        return bookMapper.BookDelete(bookId);
    }

    @GetMapping("/UpdateBookInfo")
    public int UpdateBookInfo(Book book){
        return bookMapper.BookUpdate(book);
    }

    @GetMapping("/SelectBookInfo")
    public Book SelectBookInfo(Integer bookId){
        return bookMapper.BookSelect(bookId);
    }

    @GetMapping("/SelectAllBookInfo")
    public List<Book> SelectAllBookInfo(){
        return bookMapper.BookSelectAll();
    }
}
