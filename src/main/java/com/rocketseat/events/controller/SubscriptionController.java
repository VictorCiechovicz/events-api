package com.rocketseat.events.controller;

import com.rocketseat.events.dto.ErrorMessage;
import com.rocketseat.events.dto.SubscriptionResponse;
import com.rocketseat.events.exception.EventNotFoundException;
import com.rocketseat.events.exception.SubscriptionConflitException;
import com.rocketseat.events.model.Subscription;
import com.rocketseat.events.model.User;
import com.rocketseat.events.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {


    private final SubscriptionService subscriptionService;

    @PostMapping("/subscription/{prettyName}")
    public ResponseEntity<?>  createSubscription(@PathVariable String prettyName, @RequestBody User subscriber){

        try{
     SubscriptionResponse sub = subscriptionService.createNewSubscription(prettyName,subscriber);

     if(subscriber!=null){
         return ResponseEntity.ok(sub);
     }

    }catch(EventNotFoundException ex){
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }catch(SubscriptionConflitException ex){
            return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
        }

     return ResponseEntity.badRequest().build();
}}
