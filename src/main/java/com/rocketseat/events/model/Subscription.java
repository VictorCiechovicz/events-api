package com.rocketseat.events;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_subscription", schema = "db_events")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subscriptionNumber;

    @ManyToOne
    @JoinColumn(name = "subscribed_user_id", nullable = false)
    private UserEntity subscribedUser;

    @ManyToOne
    @JoinColumn(name = "indication_user_id")
    private UserEntity indicationUser;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventEntity event;
}
