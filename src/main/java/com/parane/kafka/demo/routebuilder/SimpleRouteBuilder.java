package com.parane.kafka.demo.routebuilder;

/**
 * Created by Parani on 21/03/2018.
 */

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder  extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:C:/input?noop=true").to("file:C:/output");
    }
}
