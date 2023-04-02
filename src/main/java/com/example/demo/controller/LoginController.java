package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequestMapping("/account")
public class LoginController {



    @GetMapping("/index")
    public String index(){
        return "登陆界面";
    }


    @GetMapping("/login")
    public String login(@Param("username") String username,
                        @Param("password") String password,
                        HttpSession session){
        log.info("====");
        if ("admin".equals(username)&&"123".equals(password)){
            session.setAttribute("loginUser",username);
            log.info("跳转页面");
            return "跳转页面";
        }else {
            return "请重新登陆（跳转到登陆页面）";
        }

    }






}
