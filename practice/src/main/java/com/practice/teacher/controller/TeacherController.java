package com.practice.teacher.controller;

import com.practice.teacher.dto.TeacherReq;
import com.practice.teacher.dto.TeacherRes;
import com.practice.teacher.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "선생님",
        description = "선생님 정보 생성, 조회, 수정, 삭제 등 사용자 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;


    @Operation(summary = "선생님 정보 저장",
            description = "새로운 유저 정보를 생성하고 저장합니다. <br />"
                    + "@param UserReq.CreateDto - 유저 이름과 전화번호 <br />"
                    + "@return 201 Created 상태의 ResponseEntity <br />"
                    + "@exception 입력값 유효성 검증 실패 시 400 Bad Request 반환"
    )


    @PostMapping("")
    public ResponseEntity<Void> create(@RequestBody TeacherReq.CreateDto req) {
        teacherService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("")  //메세지함 내용 보기
    public ResponseEntity<TeacherRes.ReadPostDto> read(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.readtext());
    }

    @GetMapping("/{postId}") //메세지함 자세히 보기
    public ResponseEntity<TeacherRes.ReadPostDto> readDetail(@PathVariable Long postId){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.readDetail(postId));
    }



}
