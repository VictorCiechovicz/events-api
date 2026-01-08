package com.rocketseat.events.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "tbl_subscription", schema = "db_events")
@Data
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer subscriptionNumber;

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id", nullable = false)
    private User subscribedUser;

    @ManyToOne
    @JoinColumn(name = "indication_user_id")
    private User indicationUser;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
}
