package org.crm.crmproject.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Entity
@Getter
@Builder
@ToString(exclude = {"customer", "store"})
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    //  ManyToOne 어노테이션으로 Customer, Store 양쪽 모두를 참조하게 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;


    private String reviewText;  //  리뷰 내용

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int grade;

}
