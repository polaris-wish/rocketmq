package com.it.edu.mq.test;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

/**
 * @ClassName myproducer
 * @Description TODO
 * @Author anthony
 * @Date 2021/5/12 21:49
 **/
public class myproducer {
    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("myproducer");
        producer.setNamesrvAddr("192.168.1.10:9876");
        try {
            producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Message message = new Message("topictest", "test", (String.valueOf(i)+"hello world").getBytes());
            SendResult send = producer.send(message);
            System.out.println(send);
        }


    }
}
