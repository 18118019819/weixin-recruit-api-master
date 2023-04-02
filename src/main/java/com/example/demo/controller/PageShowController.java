package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//@RestController
//public class PageShowController {
//
//    @Autowired
//    private BookMapper bookMapper;
//
//    @GetMapping("/PageShow")
//    public String PageShow(@RequestParam("pageNum") int pageNum,
//                           @RequestParam("pageSize") int pageSize,
//                           Model model){            // HttpServletRequest request
//        PageHelper.startPage(pageNum,pageSize);
//        System.out.println("开始查询：");
//        List<Book> list=bookMapper.BookSelectAll();
//        PageInfo<Book> pageInfo=new PageInfo<>(list);
//        System.out.println(pageInfo);
//        //request.addAttribute("pageInfo",pageInfo);
//        model.addAttribute("pageInfo",pageInfo);   //都是向前台传数据，
//        System.out.println("查询结束");
//        return "查询结束";
//    }
//}
