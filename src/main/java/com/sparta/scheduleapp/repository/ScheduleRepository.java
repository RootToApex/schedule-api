package com.sparta.scheduleapp.repository;

import com.sparta.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JPA를 사용해 DB와 연결하는 인터페이스
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // 모든 일정을 수정일 기준 최신순으로 정렬
    List<Schedule> findAllByOrderByUpdatedAtDesc();

    // 특정 작성자의 일정만 골라서 수정일 내림차순으로
    List<Schedule> findAllByAuthorOrderByUpdatedAtDesc(String author);

}