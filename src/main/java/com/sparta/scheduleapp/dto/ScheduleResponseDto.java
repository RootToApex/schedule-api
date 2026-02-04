package com.sparta.scheduleapp.dto;

import com.sparta.scheduleapp.entity.Schedule;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;                  // 일정의 고유 식별자
    private String title;             // 일정 제목
    private String content;           // 일정 내용
    private String author;            // 작성자명
    private LocalDateTime createdAt;  // 생성일
    private LocalDateTime updatedAt;  // 수정일

    // Entity 객체를 DTO로 변환
    // 비밀번호(password) 제외
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.author = schedule.getAuthor();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }
}
