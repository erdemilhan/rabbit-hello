package com.sample.workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask{

    private final static String QUEUE_NAME = "taskqueue";
    private final static String MESSAGE = String.join(" ", "Message...");

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try(Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel();

            //durable queue set to True
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            //persistent messages are set
            //default exchange type (1st parameter) is used to send messages to named queue
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, MESSAGE.getBytes("UTF-8"));
            System.out.println("Sent message " + MESSAGE);
        }
    }
}