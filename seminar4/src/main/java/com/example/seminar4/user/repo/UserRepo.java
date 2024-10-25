package com.example.seminar4.user.repo;

import com.example.seminar4.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository 이거 안써도됨

public interface UserRepo extends JpaRepository<User, Long> {


}
