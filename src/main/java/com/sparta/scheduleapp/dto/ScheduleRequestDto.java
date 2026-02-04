package com.sparta.scheduleapp.dto;

import lombok.Getter;

@Getter // Postman에서 보낸 데이터를 자동으로 매핑하기
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}