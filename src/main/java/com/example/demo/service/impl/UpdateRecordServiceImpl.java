package com.example.demo.service.impl;

import com.example.demo.entity.Record;
import com.example.demo.mapper.RecordMapper;
import com.example.demo.service.UpdateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRecordServiceImpl implements UpdateRecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public void BorrowerInfoUpdate(Integer recordId,Boolean recordState) {

        Record record=recordMapper.RecordSelectById(recordId);

        record.setRecordState(recordState);

        recordMapper.RecordUpdate(record);


    }
}
