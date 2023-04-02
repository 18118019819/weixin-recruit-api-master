package com.example.demo.service;


import org.apache.ibatis.annotations.Param;

import java.text.ParseException;


public interface AddBorrowBookService {
    /**
     * 借阅的书籍信息
     * @param bookId
     * @param borrowerId
     */

    void BorrowInfo(@Param("bookId") Integer bookId, @Param("borrowerId") Integer borrowerId) ;


}
