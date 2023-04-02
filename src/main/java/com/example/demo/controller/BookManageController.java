package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Borrower;
import com.example.demo.entity.Record;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowerMapper;
import com.example.demo.mapper.RecordMapper;
import com.example.demo.service.AddReturnBookService;
import com.example.demo.service.UpdateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.AddBorrowBookService;
import java.util.Date;

@EnableScheduling
@RestController
@RequestMapping("/Book")
public class BookManageController {
    @Autowired
    private AddBorrowBookService addBorrowBookService;

    @Autowired
    private AddReturnBookService addReturnBookService;

    @Autowired
    private UpdateRecordService updateRecordService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Autowired
    private BorrowerMapper borrowerMapper;

    @GetMapping("/BookRecord")
    public String BookRecord(@RequestParam("bookId") Integer bookId,@RequestParam("borrowerId") Integer borrowerId){
        if(borrowerId!=null&&bookId!=null){
            addBorrowBookService.BorrowInfo(bookId,borrowerId);
            Book book=bookMapper.BookSelect(bookId);
            return "借书记录成功,"+"java书本还剩"+book.getBookNumber();
        }else {
            System.out.println("BookId不可为空");
            Book book=bookMapper.BookSelect(1);
            return "借书记录失败,"+"java书还剩"+book.getBookNumber();
        }
    }

    @GetMapping("/BookReturn")
    public String BookReturn(@RequestParam("BookId") Integer BookId,@RequestParam("BorrowerId")Integer BorrowerId){

        if(recordMapper.RecordSelect(BookId,BorrowerId)!=null&&BookId!=null&&BorrowerId!=null){
            addReturnBookService.ReturnInfo(BookId,BorrowerId);
            return "还书记录成功";
        }else {
            System.out.println("没有该记录");
            return "还书记录失败";
        }
    }

    @GetMapping("/RecordStateUpdate")
    public String RecordStateUpdate(Integer recordId,boolean recordState){

        Record record=recordMapper.RecordSelectById(recordId);
        Borrower borrower=borrowerMapper.BorrowerSelect(record.getBorrowerId());
        Book book=bookMapper.BookSelect(record.getBookId());

        updateRecordService.BorrowerInfoUpdate(recordId,recordState);
        return "已更改借书人"+borrower.getBorrowerName()+"对于书本:"+book.getBookName()+record.isRecordState()+"的状态";
    }

    @GetMapping("/CheckOutTime")
    public String CheckOutTime(Date recordEndTime,Integer RecordId){
        Record record=recordMapper.RecordSelectById(RecordId);
        Borrower borrower=borrowerMapper.BorrowerSelect(record.getBorrowerId());
        Book book=bookMapper.BookSelect(record.getBookId());

        if(recordEndTime.compareTo(record.getLastTime())>0){
            return "借书人："+borrower.getBorrowerName()+"所借书本"+book.getBookName()+"还未归还";
        }else {
            return "借书人："+borrower.getBorrowerName()+"所借书本"+book.getBookName()+"已经归还";
        }
    }
}
