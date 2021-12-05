package com.mnr.controller;

import com.mnr.models.Request;
import com.mnr.models.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class IntegrationController {

    private final MessageChannel remoteRequestChannel;

    public IntegrationController(@Qualifier("remoteRequest") MessageChannel remoteRequestChannel){
        this.remoteRequestChannel = remoteRequestChannel;

    }

    @GetMapping("/message/{name}")
    public String getMessage(@PathVariable("name") String name){
       Message<String> message = MessageBuilder.withPayload(name)
               .setHeader("location_id", UUID.randomUUID()).build();
       remoteRequestChannel.send(message);
       return name+", It is successful..";
    }
}
