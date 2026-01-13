package com.rocketseat.events.repository;

import com.rocketseat.events.model.Event;
import com.rocketseat.events.model.Subscription;
import com.rocketseat.events.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {
    public Subscription findByEventAndSubscriber(Event event, User user);
}
