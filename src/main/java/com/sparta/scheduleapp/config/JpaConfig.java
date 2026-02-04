package com.sparta.scheduleapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 스프링의 설정 클래스임을 선언
@EnableJpaAuditing // 작성일/수정일 JPA Auditing 활용
public class JpaConfig {
}
