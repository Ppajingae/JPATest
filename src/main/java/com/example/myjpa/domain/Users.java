package com.example.myjpa.domain;


import com.example.myjpa.entityListener.UserEntityListener;
import com.example.myjpa.enumtest.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data //상속 받는 클래스에 대해서는 toString과 EqualsAndHashCode가 작동을 안하므로 따로 Annotation을 지정해줘서 callSuper를 true를 설정해준다
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@Table(name = "users", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")}) //마이그레이션이나 이관 작업시에 같은 테이블을 연동하는 목적으로 사용 일반적으로는 @Table과 @Entity의 테이블이 동일해야 한다
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EntityListeners(value = UserEntityListener.class)
public class Users extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column //테이블의 컬럼에 관해서 컨트롤 하기 위한 Annotation
    @NonNull
    private String name;

    @Column
    @NonNull
    private String email;

//    @Column // (updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Column  // (insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    //EnumType value() default ORDINAL 이기 때문에 출력을 값이 출력이 되는 것이 아니라 Index Number가 출력이 된다
    //따라서 코드 리펙터링을 진행할때 DB에 있는 데이터가 바뀌는 버그가 발생할 수 있기 때문에 enum을 사용시 반드시 STRING 으로 타입을 지정해준다
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Review> reviews = new ArrayList<>();


//    @Transient //해당 필드에서만 사용하고 DB 테이블에는 적용이 되지 않게 하는 Annotation
//    private int birthDay;

//    // 이벤트
//    @PrePersist     // insert 메소드가 실행되기 전에 실행되는 Annotation
//    public void prePersist(){
//        System.out.println("prePersist");
//    }
//
//    @PostPersist    // Persist 메소드가 실행되기 전에 실행되는 Annotation
//    public void postPersist(){
//        System.out.println(">>> postPersist");
//    }
//
//    @PreUpdate      // merge 메소드가 실행되기 전에 실행되는 Annotation
//    public void preUpdate(){
//    }
//
//    @PostUpdate     // merge 메소드가 호출이 된 이후에 실행되는 Annotation
//    public void postUpdate(){
//        System.out.println(">>> postUpdate");
//    }
//
//    @PreRemove      // Delete 메소드가 실행되기 전에 실행되는 Annotation
//    public void preRemove(){
//        System.out.println(">>> preRemove");
//    }
//
//    @PostRemove     // Delete 메소드가 호출이 된 이후에 실행되는 Annotation
//    public void postRemove(){
//        System.out.println(">>> postRemove");
//    }
//
//    @PostLoad       // SELECT 조회가 일어난 직후에 실행되는 Annotation
//    public void postLoad(){
//        System.out.println(">>> postLoad");
//    }

}
