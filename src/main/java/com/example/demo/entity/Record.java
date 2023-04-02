package com.example.demo.entity;


import lombok.Data;
import java.util.Date;

@Data
public class Record {

    private Integer RecordId;

    /**
     * false:已被借阅
     * true：可借阅
     */
    private boolean RecordState;

    private Integer BorrowerId;

    private Integer BookId;

    private Date RecordStartTime;

    private Date RecordEndTime;

    private Date LastTime;


    public Record() {
    }


}
