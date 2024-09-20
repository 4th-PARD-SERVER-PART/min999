package com.pard.server.Assignment1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/classroom")
public class MyController {

    // 학생 출석 정보를 저장하는 Map (이름, 입장 여부)
    private Map<String, Boolean> students = new HashMap<>();

    // 학생 입장 처리 (입장한 학생은 true로 표시)
    @PostMapping ("/enter")
    public String enterClass(@RequestParam String name) {
        students.put(name, true);  // 학생이 입장하면 true로 표시
        return name + " 학생이 강의실에 입장했습니다.";
    }
//http://localhost:8080/classroom/enter?name=김민규
    //-> 김민규 학생이 입장했습니다.

    // 학생 퇴장 처리 (퇴장한 학생은 false로 표시)
    @DeleteMapping("/remove/{name}")
    public String removeStudent(@PathVariable String name) {
        if (students.containsKey(name)) {
            students.remove(name);  // 실제로 Map에서 학생을 삭제
            return name + " 학생이 삭제되었습니다.";
        } else {
            return name + " 학생은 존재하지 않습니다.";
        }
    }

    // 현재 강의실에 있는 모든 학생 목록 반환
    @GetMapping("/list")
    public Map<String, Boolean> listStudents() {
        return students;  // 학생들의 출석 정보 반환
    }

    @PutMapping ("/change")
    public String updateName(@RequestParam String oldName, @RequestParam String newName) {
        if (students.containsKey(oldName)) {
            // 기존 이름을 새로운 이름으로 변경
            Boolean isPresent = students.remove(oldName);  // 기존 이름 제거
            students.put(newName, isPresent);  // 새 이름과 함께 기존 상태를 유지
            return oldName + " 학생의 이름이 " + newName + "으로 변경되었습니다.";
        } else {
            return oldName + " 학생은 강의실에 없습니다.";
        }
    }



}
