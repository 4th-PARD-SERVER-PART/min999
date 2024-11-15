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



    @Operation(summary = "유저 정보 받아오기",
            description = "유저 ID로 사용자 정보를 조회합니다. <br />"
                    + "@param userId - 조회할 유저의 ID <br />"
                    + "@return 이름,번호와 200 OK 상태 반환 <br />"
                    + "@exception 유저 ID가 존재하지 않으면 404 Not Found 반환"
    )
    @GetMapping("/{UserId}")
    public ResponseEntity<UserRes.UserReadDto> read(@PathVariable Long UserId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.read(UserId));
    }


    @Operation(summary = "유저 정보 수정",
            description = "유저 ID를 기준으로 정보를 수정합니다. <br />"
                    + "@param userId - 수정할 유저의 ID <br />"
                    + "@param req - 수정할 유저 정보가 담긴 UserReq.CreateDto <br />"
                    + "@return 수정된 이름,번호가 담긴 UserRes.UpdateDto와 200 OK 상태 반환 <br />"
                    + "@exception 유저 ID가 존재하지 않으면 404 Not Found 반환"
    )
    @PatchMapping("/{UserId}")
    public ResponseEntity<UserRes.UserUpdateDto> patch(@PathVariable Long UserId,
                                                   @RequestBody UserReq.CreateDto req) {
        UserRes.UserUpdateDto updatedUser = userService.patch(UserId, req);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser); // 200 OK 반환
    }


    @Operation(summary = "유저 정보 삭제",
            description = "유저 ID를 기준으로 유저 정보를 삭제합니다. <br />"
                    + "@param userId - 삭제할 유저의 ID <br />"
                    + "@param req - 조회할 유저의 ID <br />"
                    + "@return 성공 시 204 No Content 상태 반환 <br />"
                    + "@exception 유저 ID가 존재하지 않으면 404 Not Found 반환"
    )
    @DeleteMapping("/{UserId}")
    public ResponseEntity<Void> delete(@PathVariable Long UserId) {
        userService.delete(UserId);
        return ResponseEntity.noContent().build(); // 204 No Content 반환
    }



    @Operation(summary = "유저 정보 및 작성한 게시물 가져오기",
            description = "유저 ID로 사용자 정보를 조회하고, 해당 사용자가 작성한 게시물 정보를 함께 반환합니다. <br />"
                    + "@param userId - 조회할 유저의 ID <br />"
                    + "@return 이름, 번호, 작성한 게시물 목록과 200 OK 상태 반환 <br />"
                    + "@exception 유저 ID가 존재하지 않으면 404 Not Found 반환"
    )
    @GetMapping("/{UserId}/posts")
    public ResponseEntity<UserRes.UserReadPostDto> readUserInfoWithPosts(@PathVariable Long UserId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.readUserPosts(UserId));
    }








}
