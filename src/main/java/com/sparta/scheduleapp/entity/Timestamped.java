package com.sparta.scheduleapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // entity가 아래 필드들을 컬럼으로 인식하게 만들기
@EntityListeners(AuditingEntityListener.class) // 엔티티가 생성/수정될 때 시간을 자동으로 기록
public abstract class Timestamped {
    @CreatedDate // 생성 시점의 날짜/시간을 기록
    @Column(updatable = false) // 생성일은 수정되지 않도록 설정
    private LocalDateTime createdAt;

    @LastModifiedDate // 수정 시점의 날짜/시간을 기록
    private LocalDateTime updatedAt;
}