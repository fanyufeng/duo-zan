package com.duode.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by fanyufeng in 19/1/27
 */
@Component
public class ScheduledService {
    @Scheduled(fixedRate = 50)
    public void cashDistribute () {
        System.out.println("test");
    }
}
