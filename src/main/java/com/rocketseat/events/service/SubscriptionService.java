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


    public SubscriptionResponse createNewSubscription(String eventName, User user){

        Subscription subs = new Subscription();
        Event evt = eventRepository.findByPrettyName(eventName);
        User userRec= userRepository.findByEmail(user.getEmail());

        if(evt == null){
           throw  new EventNotFoundException("Event not found");

        }
        if(userRec == null){
            userRec = userRepository.save(user);
        }

        subs.setEvent(evt);
        subs.setSubscriber(userRec);

        Subscription tmpSub = subscriptionRepository.findByEventAndSubscriber(evt,userRec);

        if(tmpSub == null){
            throw  new SubscriptionConflitException("Subscription not found");
        }

        Subscription res = subscriptionRepository.save(subs);

        return res;

    }


}
