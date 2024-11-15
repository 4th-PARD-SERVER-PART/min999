package com.practice.user.service;


import com.practice.exception.NoMatchingDataException;
import com.practice.post.entity.Post;
import com.practice.post.dto.PostRes;
import com.practice.post.repository.PostRepo;
import com.practice.user.dto.UserReq;
import com.practice.user.dto.UserRes;
import com.practice.user.entity.User;
import com.practice.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;

    public void create(UserReq.CreateDto req){ // 정보 저장
        User u = User.builder()
                .name(req.getName())
                .build();
        userRepo.save(u);
    }

    public UserRes.UserReadPostDto readUserPosts(Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoMatchingDataException("유저아이디 " + userId + " 가 존재하지 않습니다."));

        List<Post> posts = postRepo.findByUserId(userId);
        List<PostRes.PostReadResDto> postDtos = PostRes.PostReadResDto.postToDto(posts);

        return UserRes.UserReadPostDto.builder()
                .name(user.getName())
                .posts(postDtos)
                .build();
    }






}
