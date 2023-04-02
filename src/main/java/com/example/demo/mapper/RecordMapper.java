package com.example.demo.mapper;



import com.example.demo.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper {
    /**
     * 增加记录
     * @param record
     * @return  String
     */
    int RecordInsert(Record record);

    /**
     * 删除记录
     * @param RecordId
     * @return  String
     */
    int RecordDelete(@Param("RecordId") Integer RecordId);

    /**
     * 更新记录
     * @param record
     * @return  Record
     */
    int RecordUpdate(Record record);

    /**
     * 查询记录
     * @param BorrowerId
     * @param BookId
     * @return Record
     */
    Record RecordSelect(@Param("BookId") Integer BookId,@Param("BorrowerId") Integer BorrowerId);

    /**
     * 根据RecordId查询
     * @param RecordId
     * @return
     */
    Record RecordSelectById(@Param("RecordId")  Integer RecordId);

    /**
     * 查询全部记录
     * @return  List<Record>
     */
    List<Record> RecordSelectAll();


}

