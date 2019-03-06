package com.sample.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender{

    private final static String QUEUE_NAME = "hello";
    private final static String MESSAGE = "Hello World";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");

        try(Connection connection = factory.newConnection()){
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            //default exchange type (1st parameter) is used to send messages to named queue
            channel.basicPublish("", QUEUE_NAME, null, MESSAGE.getBytes("UTF-8"));
            System.out.println("Sent message " + MESSAGE);
        }
    }
}