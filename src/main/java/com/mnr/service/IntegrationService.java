package com.mnr.service;

import com.mnr.models.Request;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IntegrationService {
    /*@ServiceActivator(inputChannel = "remoteRequest")
    public void doSomething(Message<String> message){
//        Message<String> message : This is wrong way eventhough it works. Business logic shouldn't be aware of message pattern
        //when using serviceActivator pattern. Refer below which is the correct way of doing it.
        UUID location_id = (UUID) message.getHeaders().get("location_id");
        System.out.println(location_id+", location is updated..");
        //return "Hello, "+name+" I did something";

    }*/

    @ServiceActivator(inputChannel = "remoteRequest")
    public void doSomething(@Header("location_id") UUID locationId, @Payload String name){
        System.out.println("Payload is ="+ name);
        System.out.println(locationId+", location is updated..");
        //return "Hello, "+name+" I did something";

    }
}
