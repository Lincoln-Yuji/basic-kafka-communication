package org.acme.kafka.producer;

import java.util.UUID;

import org.acme.kafka.model.Quote;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/quotes")
public class QuotesResource {

    @Channel("quote-requests")
    Emitter<String> quoteRequestEmitter;

    @Channel("quotes")
    Multi<Quote> quotes;

    @POST
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public String createRequest() {
        UUID uuid = UUID.randomUUID();
        quoteRequestEmitter.send(uuid.toString());
        return uuid.toString();
    }

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Quote> stream() {
        return quotes;
    }
}
