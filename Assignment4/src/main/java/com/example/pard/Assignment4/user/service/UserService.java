package com.example.pard.Assignment4.user.service;

import com.example.pard.Assignment4.like.dto.LikeResDto;
import com.example.pard.Assignment4.like.entity.Good;
import com.example.pard.Assignment4.like.repository.LikeRepo;
import com.example.pard.Assignment4.post.dto.PostResDto;
import com.example.pard.Assignment4.post.entity.Post;
import com.example.pard.Assignment4.post.repository.PostRepo;
import com.example.pard.Assignment4.user.dto.UserReqDto;
import com.example.pard.Assignment4.user.dto.UserResDto;
import com.example.pard.Assignment4.user.entity.User;
import com.example.pard.Assignment4.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PostRepo postRepo;
    private final LikeRepo likeRepo;

    public void save(UserReqDto.UserCreateReqDto req){
        User u = User.builder()
                .name(req.getName())
                .num(req.getNum())
                .build();
        userRepo.save(u);
    }

    public UserResDto.UserReadResDto read(Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        List<Post> posts = postRepo.findByUserId(userId);
        List<PostResDto.PostReadResDto> postDtos = PostResDto.PostReadResDto.postToDto(posts);

        return UserResDto.UserReadResDto.builder()
                .name(user.getName())
                .num(user.getNum())
                .posts(postDtos)
                .build();
    }
    // 유저 아이디로 작성한 글 보여주기

    public UserResDto.UserReadLikeUserDto readLikeUser(Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        List<Good> goods = likeRepo.findByUserId(userId);
        List<LikeResDto.LikeResPostDto> likedPostDtos = LikeResDto.LikeResPostDto.LikePost(goods);

        return UserResDto.UserReadLikeUserDto.builder()
                .name(user.getName())
                .num(user.getNum())
                .posts(likedPostDtos)
                .build();
    }
    //유저 아이디로 좋아요 누른 글 보여주기


    /*
    @PatchMapping("/{userId}")
    public UserResDto.UserReadResDto update(@PathVariable Long userId){
        return userService.update(userId);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId){
        userService.delete(userId);
    }
    * */
    public UserResDto.UserReadResDto update(Long userId, UserReqDto.UserCreateReqDto req){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        user.updateName(req.getName());
        user.updateNum(req.getNum());

        userRepo.save(user);

        return UserResDto.UserReadResDto.builder()
                .name(user.getName())
                .num(user.getNum())
                .build();
    }

    public void delete(Long userId){
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));
        userRepo.delete(user);
    }

}





