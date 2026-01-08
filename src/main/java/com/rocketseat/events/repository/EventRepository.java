package com.rocketseat.events.repository;

import com.rocketseat.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
