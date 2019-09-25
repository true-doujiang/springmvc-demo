package com.atguigu.springmvc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class SyscTask {


    /**
     * @Description: 定义定时任务每天0点2分执行一次,查询要更新状态的账户
     * @author
     * @date 2018年10月17日 17:16:01
     *
     */
    //@Scheduled(cron = "0 0/2 * * * ?")
    //@Scheduled(cron = "0 2 0 ? * *")
    @Scheduled(cron = "0/5 * * * * ? ") // 间隔5秒执行
    public void updateDriverAmountStatus() {
        System.out.println("=======" + new Date());
    }
}
