package com.example.myjpa.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Album extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long artistId;

    private String category;

    private Long idolGroupId;

    @OneToOne(mappedBy = "album") // OneToOne Annotation을 양방향으로 사용 시에 순환 참조가 발생하므로 java.lang.StackOverflowError Exception이 발생할 수도 있다
    @ToString.Exclude // 따라서 ToString.Exclude를 통해서 해당 메소드의 ToString 사용을 하지 않으면서 java.lang.StackOverflowError Exception을 막아준다
    private AlbumReviewInfo albumReviewInfo;
}
