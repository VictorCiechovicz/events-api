package com.rocketseat.events;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_event", schema = "db_events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    @Column(nullable = false)
    private String title;

    @Column(name = "pretty_name", nullable = false, unique = true)
    private String prettyName;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double price;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
}
