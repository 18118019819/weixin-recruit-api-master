package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.entity.Record;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.RecordMapper;
import com.example.demo.service.AddReturnBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class AddReturnBookServiceImpl implements AddReturnBookService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void ReturnInfo(Integer BookId,Integer BorrowerId) {
        Book book=bookMapper.BookSelect(BookId);
        Record record=recordMapper.RecordSelect(BookId,BorrowerId);

        record.setRecordState(true);
        record.setRecordEndTime(new Date());

        book.setBookNumber(book.getBookNumber()+1);

        bookMapper.BookUpdate(book);
        recordMapper.RecordUpdate(record);
    }
}
