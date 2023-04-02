package com.example.demo.controller;

import com.example.demo.entity.Record;
import com.example.demo.mapper.RecordMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

//dad
@RestController
@RequestMapping("/RecordInfo")
public class RecordInfoController {

    @Autowired
    private RecordMapper recordMapper;

    @GetMapping("/InsertRecordInfo")
    public int InsertRecordInfo(Record record){
        return recordMapper.RecordInsert(record);
    }

    @GetMapping("/DeleteRecordInfo")
    public int DeleteRecordInfo(Integer recordId){
        return recordMapper.RecordDelete(recordId);
    }

    @GetMapping("/UpdateRecordInfo")
    public int UpdateRecordInfo(Record record){
        return recordMapper.RecordUpdate(record);
    }

    @GetMapping("/SelectRecordInfo")
    public Record SelectRecordInfo(Integer recordId){
        return recordMapper.RecordSelect(recordId,null);
    }

    @GetMapping("/SelectAllRecordInfo")
    public List<Record> SelectAllBorrowerInfo(){
        return recordMapper.RecordSelectAll();
    }

}
