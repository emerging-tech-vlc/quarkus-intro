package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

/**
 * Camel route definitions.
 */
@ApplicationScoped
public class Routes extends RouteBuilder {

    private final Greeting greeting;

    public Routes() {
        greeting = new Greeting();
        greeting.setText("Message received");
    }

    @Inject
    GreetingsKafkaProducer kafkaProducer;

    @Override
    public void configure() throws Exception {
        from("platform-http:/greetings?httpMethodRestrict=POST")
                .unmarshal()
                .json(JsonLibrary.Jackson, Greeting.class)
                .bean(kafkaProducer, "produce")
                .setBody().constant(greeting)
                .marshal().json();
    }
}
