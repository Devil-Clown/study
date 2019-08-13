package com.study.hzk.rabbitmq;

import com.rabbitmq.client.*;
import com.study.hzk.common.util.PropertiesUtil;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public class MQUtil implements Runnable {
    private String queueName = "hzk-queue";

    private Connection conn = null;
    private Channel channel = null;

    public MQUtil(){
        Properties properties = PropertiesUtil.load("src/main/resources/mq.properties");
        queueName = properties.getProperty("queue");

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(properties.getProperty("username"));
        factory.setPassword(properties.getProperty("password"));
        factory.setHost(properties.getProperty("host"));
        factory.setPort(Integer.parseInt(properties.getProperty("port")));
        try {
            conn = factory.newConnection();
        }catch (IOException e){
            e.printStackTrace();
        }catch (TimeoutException e){
            e.printStackTrace();
        }

        try {
            channel = conn.createChannel();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void send(String msg){
        try{
            channel.queueDeclare(queueName, false, false, true, null);
            channel.basicPublish("", queueName, null, msg.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                channel.close();
                conn.close();
            }catch (IOException e){
                e.printStackTrace();
            }catch (TimeoutException e){
                e.printStackTrace();
            }
        }
    }


    public void consumer() {
        try{
            channel.queueDeclare(queueName, false, false, true, null);
            Thread.sleep(1000);

            channel.basicConsume(queueName, false, "",
                    new DefaultConsumer(channel) {
                        @Override
                        public void handleDelivery(String consumerTag,
                                                   Envelope envelope,
                                                   AMQP.BasicProperties properties,
                                                   byte[] body)
                                throws IOException
                        {
                            String routingKey = envelope.getRoutingKey();
                            String contentType = properties.getContentType();
                            long deliveryTag = envelope.getDeliveryTag();
                            // (process the message components here ...)
                            System.out.println("MQ Receive:" + new String(body));
                            channel.basicAck(deliveryTag, false);
                        }
                    });
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        while(true) {
            consumer();
        }
    }
}
