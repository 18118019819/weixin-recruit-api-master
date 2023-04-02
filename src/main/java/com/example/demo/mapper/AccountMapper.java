package com.example.demo.mapper;


import com.example.demo.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper {
    /**
     * 增加用户
     * @param  account
     * @return
     */
    int AccountInsert(Account account);

    /**
     * 删除用户
     * @param accountId
     * @return
     */
    int AccountDelete(@Param("accountId") Integer accountId);

    /**
     * 更新用户
     * @param account
     * @return
     */
    int AccountUpdate(Account account);

    /**
     * 查询用户
     * @param accountId
     * @return
     */
    Account AccountSelect(@Param("accountId") Integer accountId);

    /**
     * 查询全部
     * @return
     */
    List<Account> AccountSelectAll();

}
