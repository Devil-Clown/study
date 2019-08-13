package com.study.hzk.start;

import com.study.hzk.kafka.Consumer;
import com.study.hzk.kafka.Producer;
import com.study.hzk.rabbitmq.MQUtil;
import com.study.hzk.redis.Writer;

public class Start {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Writer writer = new Writer();
        Consumer consumer = new Consumer();

        new Schedule().start(producer, 0, 3);
        new Schedule().start(writer, 0, 3);
        new Schedule().start(consumer, 0, 3);

        new Thread(new MQUtil()).start();
    }
}
