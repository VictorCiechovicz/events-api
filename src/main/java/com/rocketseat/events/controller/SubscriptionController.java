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
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SubscriptionController {


    private final SubscriptionService subscriptionService;

    @PostMapping({"/subscription/{prettyName}","/subscription/{prettyName}/{userId}"})
    public ResponseEntity<?>  createSubscription(@PathVariable String prettyName,
                                                 @PathVariable (required = false)  Integer userId,
                                                 @RequestBody User subscriber){

        try{
     SubscriptionResponse sub = subscriptionService.createNewSubscription(prettyName,subscriber,userId);

     if(subscriber!=null){
         return ResponseEntity.ok(sub);
     }

    }catch(EventNotFoundException ex){
        return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
    }catch(SubscriptionConflitException ex){
            return ResponseEntity.status(409).body(new ErrorMessage(ex.getMessage()));
        }

     return ResponseEntity.badRequest().build();
}

    @GetMapping("/subscription/{prettyName}/ranking")
    public ResponseEntity<?> generateRaningByEvent(@PathVariable String prettyName){
        try{
            return ResponseEntity.ok(subscriptionService.getCompleteRanking(prettyName).subList(0, 3));
        }catch(EventNotFoundException e){
            return ResponseEntity.status(404).body(new ErrorMessage(e.getMessage()));
        }
    }

    @GetMapping("/subscription/{prettyName}/ranking/{userId}")
    public ResponseEntity<?> generateRaningByEventAndUser(@PathVariable String prettyName, @PathVariable Integer userId){
        try{
            return ResponseEntity.ok(subscriptionService.getRankingByUser(prettyName, userId));
        }catch(Exception ex){
            return ResponseEntity.status(404).body(new ErrorMessage(ex.getMessage()));
        }
    }


}
