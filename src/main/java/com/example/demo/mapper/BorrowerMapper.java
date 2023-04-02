package com.example.demo.mapper;


import com.example.demo.entity.Borrower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BorrowerMapper {

        /**
         * 增加借阅人
         * @param borrower
         * @return  String
         */
        int BorrowerInsert( Borrower borrower);

        /**
         * 删除借阅人
         * @param borrowerId
         * @return      String
         */
        int BorrowerDelete(@Param("BorrowerId") Integer borrowerId);

        /**
         * 更新借阅人
         * @param borrower
         * @return  Borrower
         */
        Borrower BorrowerUpdate(Borrower borrower);

        /**
         * 查询借阅人
         * @param borrowerId
         * @return      Borrower
         */
        Borrower BorrowerSelect(@Param("BorrowerId") Integer borrowerId);

        /**
         * 查询全部借阅人
         * @return      List<Borrower>
         */
        List<Borrower> BorrowerSelectAll();

    }


