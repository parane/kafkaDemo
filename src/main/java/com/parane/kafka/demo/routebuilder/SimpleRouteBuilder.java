package com.parane.kafka.demo.routebuilder;

/**
 * Created by Parani on 21/03/2018.
 */

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C:/input?noop=true")
                .process(new CamelProcessor()).to("file:C:/output");

        from("file:C:/inbox")
                .doTry()
                .process((Exchange exchange)->{
                    System.out.println("Exception Thrown");
                    throw new CamelCustomException();}).to("file:C:/outbox")
                .doCatch(CamelCustomException.class).process((Exchange exchange)->{System.out.println("Exception Handled");}
                );
    }
}
