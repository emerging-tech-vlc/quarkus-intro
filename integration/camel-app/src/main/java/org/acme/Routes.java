package org.acme;

import java.util.function.Function;
import java.util.function.Predicate;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.util.json.JsonObject;

/**
 * Camel route definitions.
 */
@ApplicationScoped
public class Routes extends RouteBuilder {

    @Inject
    GreetingsKafkaProducer kafkaProducer;

    @Override
    public void configure() throws Exception {
        from("platform-http:/greetings?httpMethodRestrict=POST")
            .log("#### New incoming http message ####")
            .unmarshal()
            .json(JsonLibrary.Jackson, Greeting.class)
            .choice()
                .when().method(isSendToKafka())
                    .log("Sending message to kafka")
                    .to("seda:kafka-producer")
                .otherwise()
                    .log("Not sending any message to kafka")
                    .log("Greeting received: ${body.text}")
            .end()
            .setBody().method(setResult())
            .marshal().json();

        from("seda:kafka-producer")
            .log("Message passed using seda")
            .bean(kafkaProducer);
            // .to("bean:greetingsKafkaProducer");

    }

    Predicate<Greeting> isSendToKafka() {
        return g -> g.isSend();
    }

    Function<Greeting, JsonObject> setResult() {
        return g -> {
            JsonObject json = new JsonObject();
            if (g.isSend()) {
                json.put("result", "Greeting successfully processed and sent to kafka");
            } else {
                json.put("result", "Greeting successfully processed");
            }
            return json;
        };
    }
}
