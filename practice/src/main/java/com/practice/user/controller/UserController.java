package com.practice.user.controller;


import com.practice.user.dto.UserReq;
import com.practice.user.dto.UserRes;
import com.practice.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 관리",
        description = "유저 정보 생성, 조회, 수정, 삭제 등 사용자 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "유저 정보 저장",
            description = "새로운 유저 정보를 생성하고 저장합니다. <br />"
                    + "@param UserReq.CreateDto - 유저 이름과 전화번호 <br />"
                    + "@return 201 Created 상태의 ResponseEntity <br />"
                    + "@exception 입력값 유효성 검증 실패 시 400 Bad Request 반환"
    )
    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody UserReq.CreateDto req) {
        userService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "유저 게시물 목록 조회",
            description = """
                특정 유저가 작성한 게시물 목록을 조회합니다.
                @param userId - 게시물을 조회할 유저의 ID
                @return 유저의 게시물 목록과 200 OK 상태 반환
                @exception 유저 ID가 존재하지 않을 경우 404 Not Found 반환
                """
    )
    @GetMapping("/{UserId}/posts")
    public ResponseEntity<UserRes.UserReadPostDto> readUserInfoWithPosts(@PathVariable Long UserId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUserPosts(UserId));
    }


}
