package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;

/**
 * GreetingsKafkaProducer
 */
@ApplicationScoped
@RegisterForReflection
@Named("greetingsKafkaProducer")
public class GreetingsKafkaProducer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    @Channel("out-greetings")
    Emitter<String> emitter;

    public void produce(Greeting greeting) {
        logger.info("Sending greeting {} to kafka", greeting.getText());
        emitter.send(greeting.getText());
    }
    
}