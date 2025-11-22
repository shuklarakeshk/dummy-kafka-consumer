package com.sonata.javawa.dummies.kafka;

import io.quarkus.runtime.Startup;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.*;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
@Startup
@Slf4j
public class MyMessagingApplication {




    @Incoming("ktopic")
    public Uni<Void> processMessage(ConsumerRecord<String,String> message) {
        log.info("Received message for partition: {}", message.partition());
        log.info("Received message : {}", message.value());

        return Uni.createFrom().voidItem();
    }
}
