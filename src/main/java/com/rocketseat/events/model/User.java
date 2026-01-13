package com.rocketseat.events.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "tbl_user", schema = "db_events")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "user_name", length = 255, nullable = false)
    private String name;

    @Column(name = "user_email", length = 255, nullable = false, unique = true)
    private String email;

}
