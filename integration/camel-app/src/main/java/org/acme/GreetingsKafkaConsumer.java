package org.acme;

import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.smallrye.reactive.messaging.kafka.KafkaMessage;

/**
 * GreetingsKafkaConsumer
 */
@ApplicationScoped
public class GreetingsKafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Incoming("greetings")
    public CompletionStage<Void> greetingsConsumer(KafkaMessage<String, String> msg) {
        logger.info("Kafka message received: {}", msg.getPayload());
        return msg.ack();
    }
    
    // @Incoming("greetings")
    // public void greetingsConsumer(String msg) {
    //     logger.info("Kafka message received: {}", msg);
    // }

}