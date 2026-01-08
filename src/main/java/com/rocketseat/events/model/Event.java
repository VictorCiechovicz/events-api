package com.rocketseat.events.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_event", schema = "db_events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
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
