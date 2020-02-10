package com.yangyuscript.mq.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Desc:
 * @Author: lingx
 * @Date: 15:58 2020/2/8
 */
public class MyConsumer {
    private static final String ACTIVE_MQ_URL = "tcp://localhost:61616";

    public static void main(String[] args) throws JMSException {
        //创建工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVE_MQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标，并标识队列名称，消费者根据队列名称接受数据
        Destination destination = session.createQueue("myQueue");
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //创建消费的监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("消费的消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
