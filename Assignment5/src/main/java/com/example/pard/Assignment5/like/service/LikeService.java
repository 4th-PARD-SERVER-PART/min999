package com.example.pard.Assignment5.like.service;



import com.example.pard.Assignment5.like.entity.Good;
import com.example.pard.Assignment5.like.repository.LikeRepo;
import com.example.pard.Assignment5.post.entity.Post;
import com.example.pard.Assignment5.post.repository.PostRepo;
import com.example.pard.Assignment5.user.entity.User;
import com.example.pard.Assignment5.user.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepo likeRepo;
    private final UserRepo userRepo;
    private final PostRepo postRepo;


    @Transactional
    public void save (Long userId, Long postId) {
        // 유저아이디,포스트아이디 조합으로 좋아요 누른 기록있는지 확인
        boolean exists = likeRepo.existsByUserIdAndPostId(userId, postId);
        // 이미 like=true로 존재한다면
        if (exists) {
            // 한번 더 누른 것으로 -> 좋아요 취소 like컬럼 사라짐
            likeRepo.deleteByUserIdAndPostId(userId, postId);
        } else {
            // 좋아요가 없으면 새로 추가
            Good g = Good.builder()
                    .user(User.builder().id(userId).build())  // ID만으로 객체 설정
                    .post(Post.builder().id(postId).build())  // ID만으로 객체 설정
                    .isLike(true)
                    .build();
                    likeRepo.save(g);
        }
    }



}
