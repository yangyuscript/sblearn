package com.yangyuscript.mq.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:22 2020/2/8
 */
public class MyProducer {
    private static final String ACTIVE_MQ_URL = "tcp://localhost:61616";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标，并标识队列名称，消费者根据队列名称接受数据
        Destination destination = session.createQueue("myQueue");
        //创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        //向队列推送10个文本消息数据
        for (int i = 0; i < 10; i++) {
            //创建文本消息
            TextMessage message = session.createTextMessage("第" + i + "个文本消息");
            //发送消息
            producer.send(message);
            //在本地打印消息
            System.out.println("已发送的消息："+message.getText());
        }
        connection.close();
    }
}
