package com.example.demo.controller;


import com.example.demo.entity.Borrower;
import com.example.demo.mapper.BorrowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BorrowerInfo")
public class BorrowerInfoController {

    @Autowired
    private BorrowerMapper borrowerMapper;

    @GetMapping("/InsertBorrowerInfo")
    public int InsertBorrowerInfo(Borrower borrower){
        return borrowerMapper.BorrowerInsert(borrower);
    }

    @GetMapping("/DeleteBorrowerInfo")
    public int DeleteBorrowerInfo(Integer borrowerId){
        return borrowerMapper.BorrowerDelete(borrowerId);
    }

    @GetMapping("/UpdateBorrowerInfo")
    public Borrower UpdateBorrowerInfo(Borrower borrower){
        return borrowerMapper.BorrowerUpdate(borrower);
    }

    @GetMapping("/SelectBorrowerInfo")
    public Borrower SelectBorrowerInfo(Integer borrowerId){
        return borrowerMapper.BorrowerSelect(borrowerId);
    }

    @GetMapping("/SelectAllBorrowerInfo")
    public List<Borrower> SelectAllBorrowerInfo(){
        return borrowerMapper.BorrowerSelectAll();
    }

}
