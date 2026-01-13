package com.rocketseat.events.service;

import com.rocketseat.events.dto.SubscriptionResponse;
import com.rocketseat.events.exception.EventNotFoundException;
import com.rocketseat.events.exception.SubscriptionConflitException;
import com.rocketseat.events.model.Event;
import com.rocketseat.events.model.Subscription;
import com.rocketseat.events.model.User;
import com.rocketseat.events.repository.EventRepository;
import com.rocketseat.events.repository.SubscriptionRepository;
import com.rocketseat.events.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    public SubscriptionResponse createNewSubscription(String eventName, User user,Integer userId){

        Subscription subs = new Subscription();
        Event evt = eventRepository.findByPrettyName(eventName);
        User userRec= userRepository.findByEmail(user.getEmail());

        if(evt == null){
           throw  new EventNotFoundException("Event not found");

        }
        if(userRec == null){
            userRec = userRepository.save(user);
        }
        User indicator =  userRepository.findById(userId).orElse(null);
if(indicator == null){
    throw  new EventNotFoundException("User not found");
}


        subs.setEvent(evt);
        subs.setSubscriber(userRec);
        subs.setIndication(indicator);

        Subscription tmpSub = subscriptionRepository.findByEventAndSubscriber(evt,userRec);

        if(tmpSub == null){
            throw  new SubscriptionConflitException("Subscription not found");
        }

        Subscription res = subscriptionRepository.save(subs);

        return new SubscriptionResponse(res.getSubscriptionNumber(),"http://code"+res.getIndication());

    }


}
