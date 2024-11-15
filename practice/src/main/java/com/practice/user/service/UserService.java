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
                .phone(req.getPhone())
                .build();
        userRepo.save(u);
    }

    public UserRes.UserReadDto read(Long userId) { // 유저 정보 불러오기
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoMatchingDataException("유저아이디 " + userId + " 가 존재하지 않습니다."));
        return UserRes.UserReadDto.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .build();
    }


    public UserRes.UserUpdateDto patch(Long userId, UserReq.CreateDto req) { // 유저 정보 수정
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoMatchingDataException("유저아이디 " + userId + " 가 존재하지 않습니다."));

        // 유저 정보 업데이트
        user.updateName(req.getName());
        user.updatePhone(req.getPhone());
        userRepo.save(user);

        // 업데이트된 유저 정보를 UpdateDto로 반환
        return UserRes.UserUpdateDto.builder()
                .name(user.getName())
                .phone(user.getPhone())
                .build();
    }

    public void delete(Long userId) { // 유저 정보 삭제
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoMatchingDataException("유저아이디 " + userId + " 가 존재하지 않습니다."));

        userRepo.delete(user);
    }

    public UserRes.UserReadPostDto readUserPosts(Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoMatchingDataException("유저아이디 " + userId + " 가 존재하지 않습니다."));

        List<Post> posts = postRepo.findByUserId(userId);
        List<PostRes.PostReadDto> postDtos = PostRes.PostReadDto.postToDto(posts);

        return UserRes.UserReadPostDto.builder()
                .name(user.getName())
                .num(user.getPhone())
                .posts(postDtos)
                .build();

    }






}
