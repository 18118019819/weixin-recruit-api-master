package com.example.demo.quartz;

import com.example.demo.entity.Record;
import com.example.demo.mapper.RecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Component
public class CheckOutTime {

    @Autowired
    private RecordMapper recordMapper;

    //@Scheduled(fixedDelay = 10*1000)

    //@Scheduled(cron = "*/10 * * * * ?")
    public void CheckRecordTest() {
        List<Record> checkRecord = recordMapper.RecordSelectAll();
        Calendar calendar = Calendar.getInstance();
        log.info("=============开始执行检测图书超时=============");
        for (Record cr : checkRecord) {
            System.out.println(cr.getRecordId());
            log.info("RecordId:" + cr.getRecordId());
            if(cr.isRecordState()){
                log.info("已归还");
            }else if(cr.getLastTime().compareTo(calendar.getTime()) > 0){
                log.info("还未超时,未归还");
            }else {
                log.info("已超时,未归还");
            }
        }
        log.info("=========检测结束=========");
    }
}



