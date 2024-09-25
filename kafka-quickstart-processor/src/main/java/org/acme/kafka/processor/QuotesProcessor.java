package org.acme.kafka.processor;

import java.util.Random;

import org.acme.kafka.model.Quote;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotesProcessor {
    
    private Random rand = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    public Quote process(String quoteRequest) throws InterruptedException {
        Thread.sleep(500);
        return new Quote(quoteRequest, rand.nextInt(100));
    }
}
