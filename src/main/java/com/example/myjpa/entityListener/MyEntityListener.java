package com.example.myjpa.entityListener;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class MyEntityListener {

    @PrePersist
    public void prePersist(Object o){ //인자의 타입이 무엇인지 모르기 때문에 Object타입을 받는다
        if(o instanceof Auditable){ // 타입이 Auditable일 경우 형변환 후 값을 적용한다
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object o){
        if(o instanceof Auditable){
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
