package com.sparta.scheduleapp.service;

import com.sparta.scheduleapp.dto.ScheduleRequestDto;
import com.sparta.scheduleapp.dto.ScheduleResponseDto;
import com.sparta.scheduleapp.entity.Schedule;
import com.sparta.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    // 전체 일정 조회
    public List<ScheduleResponseDto> getSchedules(String author) {

        if (author != null) {
            return scheduleRepository.findAllByAuthorOrderByUpdatedAtDesc(author)
                    .stream().map(ScheduleResponseDto::new).toList();
        }
        // 전체 목록을 최신순으로 반환
        return scheduleRepository.findAllByOrderByUpdatedAtDesc()
                .stream().map(ScheduleResponseDto::new).toList();
    }

    // 특정 일정 1개만 조회 (ID 사용)
    public ScheduleResponseDto getSchedule(Long id) {
        // DB에서 ID로 찾는데 없으면 에러 띄우기
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));
        return new ScheduleResponseDto(schedule);
    }

    @Transactional // 변경 감지
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
        // 해당 일정이 있는지 확인
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다."));

        // 비밀번호 일치 여부 확인
        if (!schedule.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 일치하면 수정
        schedule.update(requestDto);

        return id;
    }
}
