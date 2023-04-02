package com.example.demo.service;

import org.apache.ibatis.annotations.Param;

public interface UpdateRecordService {
    /**
     * 单独更改记录中状态
     * @param recordId
     * @param recordState
     */

    void BorrowerInfoUpdate (@Param("recordId") Integer recordId,@Param("RecordState") Boolean recordState);
}
