package com.sparta.scheduleapp.controller;

import com.sparta.scheduleapp.dto.ScheduleRequestDto;
import com.sparta.scheduleapp.dto.ScheduleResponseDto;
import com.sparta.scheduleapp.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // JSON 데이터를 반환하는 컨트롤러임을 선언
@RequestMapping("/api") // 모든 API 주소 앞에 /api가 붙도록 설정
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성 API (POST 방식)
    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        // @RequestBody를 통해 Postman이 보낸 JSON 데이터를 DTO로 받기
        // ResponseEntity.ok()를 통해 HTTP 상태 코드 200과 함께 결과를 반환
        return ResponseEntity.ok(scheduleService.createSchedule(requestDto));
    }
}