package com.practice.post.service;

import com.practice.exception.NoMatchingDataException;
import com.practice.post.dto.PostReq;
import com.practice.post.repository.PostRepo;
import com.practice.user.entity.User;
import com.practice.post.entity.Post;
import com.practice.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private  final PostRepo postRepo;
    private final UserRepo userRepo;

    public void create(PostReq.CreateDto req, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoMatchingDataException("유저아이디 " + userId + " 가 존재하지 않습니다."));
        Post p = Post.builder()
                .text(req.getText())
                .user(user)
                .build();
        postRepo.save(p);
    }

    


}
