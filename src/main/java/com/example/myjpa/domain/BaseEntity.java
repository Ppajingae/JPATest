package com.example.myjpa.domain;

import com.example.myjpa.entityListener.Auditable;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass // 해당 클래스의 필드를 상속 받는 Entity의 컬럼으로 포함시켜주는 Annotation
@EntityListeners(value = AuditingEntityListener.class)
public class BaseEntity implements Auditable {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
