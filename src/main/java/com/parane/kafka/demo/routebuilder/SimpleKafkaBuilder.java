package com.parane.kafka.demo.routebuilder;

import org.apache.camel.builder.RouteBuilder;

/**
 * Created by Parani on 21/03/2018.
 */
public class SimpleKafkaBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String topicName = "topic=test";
        String kafkaServer = "kafka:localhost:9092";
        String zooKeeperHost = "zookeeperHost=localhost&zookeeperPort=2181";
        String serializerClass = "serializerClass=kafka.serializer.StringEncoder";

        String toKafka = new StringBuilder().append(kafkaServer).append("?").append(topicName).append("&")
                .append(zooKeeperHost).append("&").append(serializerClass).toString();

        from("file:C:/input?noop=true").split().tokenize("\n").to(toKafka);
    }
}