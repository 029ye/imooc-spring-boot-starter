package com.superz.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    // 定义每过三秒执行一次任务
//    @Scheduled(fixedRate = 3000)
//    @Scheduled(cron = "4-40 * * * * ? ")
    public void reportCurrentTime(){
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
