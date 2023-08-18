package com.example.myjpa.domain;


import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Album extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long artistId;

    private String category;

    @OneToOne(mappedBy = "album") // OneToOne Annotation을 양방향으로 사용 시에 순환 참조가 발생하므로 java.lang.StackOverflowError Exception이 발생할 수도 있다
    @ToString.Exclude // 따라서 ToString.Exclude를 통해서 해당 메소드의 ToString 사용을 하지 않으면서 java.lang.StackOverflowError Exception을 막아준다
    private AlbumReviewInfo albumReviewInfo;

    @OneToMany
    @JoinColumn(name = "album_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @ToString.Exclude
    private IdolGroup idolGroup;
}
