package com.sparta.scheduleapp.service;

import com.sparta.scheduleapp.dto.ScheduleRequestDto;
import com.sparta.scheduleapp.dto.ScheduleResponseDto;
import com.sparta.scheduleapp.entity.Schedule;
import com.sparta.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 스프링이 관리하는 서비스 클래스 선언
@RequiredArgsConstructor // final이 붙은 필드(repository)를 생성자 주입 방식으로 가져오기
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정을 생성하고 저장하는 로직
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto에 담긴 데이터를 사용하여 Schedule 엔티티(객체) 생성
        Schedule schedule = new Schedule(requestDto);

        // JPA Repository를 사용하여 DB에 엔티티를 저장
        Schedule savedSchedule = scheduleRepository.save(schedule);

        // 저장된 엔티티를 응답용 DTO로 변환하여 반환
        return new ScheduleResponseDto(savedSchedule);
    }
}
