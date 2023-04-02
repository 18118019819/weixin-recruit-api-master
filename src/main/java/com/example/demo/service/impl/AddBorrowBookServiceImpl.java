package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.entity.Record;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.RecordMapper;
import com.example.demo.service.AddBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



@Service
public class AddBorrowBookServiceImpl implements AddBorrowBookService {

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void BorrowInfo(Integer bookId, Integer borrowerId)  {
        Calendar cal =Calendar.getInstance();
        Book book=bookMapper.BookSelect(bookId);

        if(book.getBookNumber()>0){
            Record record=new Record();
            //更新书本数量
            book.setBookNumber(book.getBookNumber()-1);
            bookMapper.BookUpdate(book);
            //记录书，人，结束时间，规定时间，状态
            record.setBookId(bookId);
            record.setBorrowerId(borrowerId);
            record.setRecordStartTime(cal.getTime());
            cal.add(Calendar.MINUTE,10);
            record.setLastTime(cal.getTime());
            record.setRecordState(false);
            recordMapper.RecordInsert(record);
        }else {
            System.out.println("书本已被借完");
        }
    }
}



