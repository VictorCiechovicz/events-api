package com.rocketseat.events;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_user", schema = "db_events")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;
    private String userEmail;
}
