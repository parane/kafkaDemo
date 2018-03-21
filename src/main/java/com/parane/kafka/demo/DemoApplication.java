package com.parane.kafka.demo;

import com.parane.kafka.demo.routebuilder.SimpleKafkaBuilder;
import com.parane.kafka.demo.routebuilder.SimpleRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;


public class DemoApplication {

	public static void main(String[] args) {
		SimpleRouteBuilder routeBuilder = new SimpleRouteBuilder();
		SimpleKafkaBuilder kafkaBuilder = new SimpleKafkaBuilder();
		CamelContext ctx = new DefaultCamelContext();
		try {
			ctx.addRoutes(kafkaBuilder);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
