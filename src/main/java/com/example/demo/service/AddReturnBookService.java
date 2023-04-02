package com.example.demo.service;

import org.apache.ibatis.annotations.Param;

public interface AddReturnBookService {

    /**
     * 退还书籍，book数目增加，改变借还状态
     * @param BookId
     * @param BorrowerId
     */
    void ReturnInfo(@Param("BookId") Integer BookId, @Param("BorrowerId") Integer BorrowerId);
}
