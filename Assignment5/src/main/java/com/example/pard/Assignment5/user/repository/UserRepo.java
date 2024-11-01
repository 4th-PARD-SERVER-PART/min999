package com.example.pard.Assignment5.user.repository;

import com.example.pard.Assignment5.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {


    Optional<User> findByNum(String email);

}
