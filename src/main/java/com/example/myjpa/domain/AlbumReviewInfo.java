package com.example.myjpa.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AlbumReviewInfo extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private float averageReviewScore;

    private int reviewCount;

    @OneToOne(optional = false) // 일대일 연관 관계 Mapping
    private Album album;


}
