package com.parane.kafka.demo.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Parani on 21/03/2018.
 */
public class CamelProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        //step 2
        String originalFileContent = (String) exchange.getIn().getBody(String.class);
        String upperCaseFileContent = originalFileContent.toUpperCase();
        exchange.getIn().setBody(upperCaseFileContent);
        /*System.out.println("Exception Thrown");
        throw new CamelCustomException();*/
    }

}