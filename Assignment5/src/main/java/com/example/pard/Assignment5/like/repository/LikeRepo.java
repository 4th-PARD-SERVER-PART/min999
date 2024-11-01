package com.example.pard.Assignment5.like.repository;


import com.example.pard.Assignment5.like.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepo extends JpaRepository<Good,Long> {
    boolean existsByUserIdAndPostId(Long userId, Long postId);
    void deleteByUserIdAndPostId(Long userId, Long postId);
    List<Good> findByPostId(Long postId);
    List<Good> findByUserId(Long userId);
}
