package com.example.demo.entity;


import lombok.Data;


@Data
public class Book {


    private Integer BookId;

    private String BookName;

    private int BookNumber;
//    /**
//     *
//     * false:已被借阅
//     * true：可借阅
//
//    private boolean BookState;
//*/

}
