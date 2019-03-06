
# Introduction

This repository implements the examples listed on https://www.rabbitmq.com/tutorials

# Preconditions

Start your Rabbit server before running the code samples here
Rabbit admin console: http://localhost:15672/
Login with guest, guest credentials


# How to execute the examples

## Hello
Simply run receiver then the sender

## Workqueues
Run Worker: mvn exec:java -Dexec.mainClass="com.sample.workqueues.Worker" -Dexec.args=“"

## Routing
mvn exec:java -Dexec.mainClass="com.sample.routing.ReceiveLogsDirect" -Dexec.args=“error”
mvn exec:java -Dexec.mainClass="com.sample.routing.ReceiveLogsDirect" -Dexec.args=“info warning”
mvn exec:java -Dexec.mainClass="com.sample.routing.EmitLogDirect" -Dexec.args=“error PROBLEM”

## Topic with Routing
mvn exec:java -Dexec.mainClass="com.sample.topic.ReceiveLogsTopic" -Dexec.args=“#”
mvn exec:java -Dexec.mainClass="com.sample.topic.ReceiveLogsTopic" -Dexec.args=“*.critical”
mvn exec:java -Dexec.mainClass="com.sample.topic.EmitLogTopic" -Dexec.args=“system.warning ‘Just a system warning’”
mvn exec:java -Dexec.mainClass="com.sample.topic.EmitLogTopic" -Dexec.args=“app.critical ‘A critical app problem'”
