package com.example.demo.util;


import lombok.Data;

@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageSize;
    /**
     * 每页数量
     */
    private int pageNum;

}
