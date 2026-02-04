package com.sparta.scheduleapp.repository;

import com.sparta.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA를 사용해 DB와 연결하는 인터페이스
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}