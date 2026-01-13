package com.rocketseat.events.repository;


import com.rocketseat.events.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {

    public User findByEmail(String email);
}
