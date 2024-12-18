package com.example.pard.Assignment4.post.repository;

import com.example.pard.Assignment4.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);//시간기준으로 오름차순

}
