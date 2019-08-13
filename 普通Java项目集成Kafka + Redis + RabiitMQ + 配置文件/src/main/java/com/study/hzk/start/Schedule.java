package com.study.hzk.start;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schedule {
    private ScheduledExecutorService executorService;
    private int size = 8;

    public Schedule(){
        executorService = Executors.newScheduledThreadPool(size);
    }
    public Schedule(int size){
        this.size = size;
        executorService = Executors.newScheduledThreadPool(size);
    }

    public void start(Runnable runnable, long delay, int per){
//        executorService.schedule(runnable, delay, timeUnit);
        executorService.scheduleAtFixedRate(runnable, delay, per, TimeUnit.SECONDS);
    }

    public void close(){
        executorService.shutdown();
    }
}
