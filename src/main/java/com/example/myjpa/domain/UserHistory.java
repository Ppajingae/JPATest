package com.example.myjpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @NonNull
    private String name;

    @NonNull
    private String email;

}
