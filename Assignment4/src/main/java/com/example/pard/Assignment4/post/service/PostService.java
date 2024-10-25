package com.example.pard.Assignment4.post.service;

import com.example.pard.Assignment4.like.dto.LikeResDto;
import com.example.pard.Assignment4.like.entity.Good;
import com.example.pard.Assignment4.like.repository.LikeRepo;
import com.example.pard.Assignment4.post.dto.PostReqDto;
import com.example.pard.Assignment4.post.dto.PostResDto;
import com.example.pard.Assignment4.post.entity.Post;
import com.example.pard.Assignment4.post.repository.PostRepo;
import com.example.pard.Assignment4.user.entity.User;
import com.example.pard.Assignment4.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final LikeRepo likeRepo;

    public void create(Long userId, PostReqDto.PostCreateReqDto req){
        /*Optional <User> u = userRepo.findById(userId);
        findById는 옵셔널(wrapper)를 반납
        -> 정확히 user 객체를 반납해줘야  빌더 가능
        */
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다."));

        Post p = Post.builder()
                .title(req.getTitle())
                .text(req.getText())
                .user(user)
                .build();
        postRepo.save(p);
    }

    public PostResDto.PostReadResDto read (Long postId){

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 포스트를 찾을 수 없습니다."));
        return PostResDto.PostReadResDto.builder()
                .title(post.getTitle())
                .text(post.getText())
                .build();
    }


    public PostResDto.PostLikeResDto readUser(Long postId) {
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 포스트를 찾을 수 없습니다.")); //포스트 찾고ㅓ
        //List<Post> posts = postRepo.findByUserId(userId);

        List<Good> goods = likeRepo.findByPostId(postId);
        List<LikeResDto.LikeResUserDto> postDtos = LikeResDto.LikeResUserDto.LikeUser(goods);

        return PostResDto.PostLikeResDto.builder()
                .title(post.getTitle())
                .text(post.getText())
                .likeUsers(postDtos)
                .build();
    }

    public PostResDto.PostReadResDto update(Long postId, PostReqDto.PostCreateReqDto req){
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 포스트를 찾을 수 없습니다.")); //포스트 찾아서

        post.updateTitle(req.getTitle());
        post.updateText(req.getText());

        postRepo.save(post);

        return  PostResDto.PostReadResDto.builder()
                .title(req.getTitle())
                .text(req.getText())
                .build();
    }

    public void delete(Long postId){
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 포스트를 찾을 수 없습니다.")); //포스트 찾아서
        postRepo.delete(post);
    }
}
