package com.practice.post.controller;


import com.practice.post.dto.PostReq;
import com.practice.post.repository.PostRepo;
import com.practice.post.service.PostService;
import com.practice.user.dto.UserReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "게시글 관리",
        description = "게시글 생성, 조회, 수정, 삭제 등 사용자 관리 API")
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @Operation(summary = "게시글 정보 저장",
            description = "새로운 게시글 정보를 생성하고 저장합니다. <br />"
                    + "@param PostReq.CreateDto - 게시글 제목,내용, userId - 작성자아이디 <br />"
                    + "@return 201 Created 상태의 ResponseEntity <br />"
                    + "@exception 입력값 유효성 검증 실패 시 400 Bad Request 반환"
    )
    @PostMapping("/{userId}")
    public ResponseEntity<Void> create(@RequestBody PostReq.CreateDto req,
                                       @PathVariable Long userId) {
        postService.create(req,userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @Operation(
            summary = "게시물 삭제",
            description = """
                    게시물 ID를 기준으로 게시물을 삭제합니다.
                    @param postId - 삭제할 게시물의 ID
                    @return 성공 시 204 No Content 상태 반환
                    @exception 게시물 ID가 존재하지 않을 경우 404 Not Found 반환
                    """
    )
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();  // 204 No Content 응답
    }









}
