package com.example.demo.controller;


import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Account")
public class AccountInfoController {
    
    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/InsertAccountInfo")
    public int InsertAccountInfo(Account account){
        return accountMapper.AccountInsert(account);
    }

    @GetMapping("/DeleteAccountInfo")
    public int DeleteAccountInfo(Integer AccountId){
        return accountMapper.AccountDelete(AccountId);
    }

    @GetMapping("/UpdateAccountInfo")
    public int UpdateAccountInfo(Account account){
        return accountMapper.AccountUpdate(account);
    }

    @GetMapping("/SelectAccountInfo")
    public Account SelectAccountInfo(Integer accountId){
        return accountMapper.AccountSelect(accountId);
    }

    @GetMapping("/SelectAllAccountInfo")
    public List<Account> SelectAllAccountInfo(){
        return accountMapper.AccountSelectAll();
    }


}
