package com.practice.teacher.service;


import com.practice.post.repository.PostRepo;
import com.practice.teacher.dto.TeacherReq;
import com.practice.teacher.dto.TeacherRes;
import com.practice.teacher.entity.Teacher;
import com.practice.teacher.repository.TeacherRepo;
import com.practice.post.dto.PostRes;
import com.practice.post.entity.Post;
import com.practice.post.repository.PostRepo;
import com.practice.exception.NoMatchingDataException;
import com.practice.user.entity.User;
import com.practice.user.repository.UserRepo;
import com.practice.user.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepo teacherRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;


    public void create(TeacherReq.CreateDto req){ // 정보 저장
        Teacher T = Teacher.builder()
                .name(req.getName())
                .build();
        teacherRepo.save(T);
    }

    public TeacherRes.ReadPostDto readtext(){

        List<Post> posts = postRepo.findAll(); //포스트 정보를 모두 찾아서
        List<PostRes.PostReadResDto> postDtos = PostRes.PostReadResDto.postToDto(posts);

        return TeacherRes.ReadPostDto.builder()
                .posts(postDtos)
                .build();
    }// 보내주기



    //상세보기
    public TeacherRes.ReadDto readDetail(Long postId){

       Post post = postRepo.findById(postId)
              .orElseThrow(() -> new NoMatchingDataException("포스트 " + postId + " 가 존재하지 않습니다."));

        return TeacherRes.ReadDto.builder()
                .name(post.getUser().getName())
                .text(post.getText())
                .build();
    }




















}
