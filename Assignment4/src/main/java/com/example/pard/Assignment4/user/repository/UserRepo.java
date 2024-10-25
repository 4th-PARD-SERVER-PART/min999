package com.example.pard.Assignment4.user.repository;

import com.example.pard.Assignment4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


}
