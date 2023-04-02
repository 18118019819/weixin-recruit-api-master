package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface BookMapper {
    /**
     * 增加书本
     * @param book
     * @return int
     */
    int BookInsert(Book book);

    /**
     * 删除书本
     * @param BookId
     * @return int
     */
    int BookDelete(@Param("BookId") Integer BookId);

    /**
     * 更新图书
     * @param book
     * @return String
     */
    int BookUpdate(Book book);

    /**
     * 查询图书
     * @param BookId
     * @return  List<Book>
     */
    Book BookSelect(@Param("BookId") Integer BookId);

    /**
     * 查询全部
     * @return List<Book>
     */
    List<Book> BookSelectAll();

}
