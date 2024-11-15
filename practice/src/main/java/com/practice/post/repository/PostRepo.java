package com.practice.post.repository;

import com.practice.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);//시간기준으로 오름차순
}
