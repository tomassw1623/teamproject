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
    private Long reviewNo;

    //  ManyToOne 어노테이션으로 Customer, Store 양쪽 모두를 참조하게 설정
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Store store;


    private String reviewText;  //  리뷰 내용

    @Column(nullable = false)
    @Min(1)
    @Max(5)
    private int grade;  //  별점

    //  리뷰 내용, 별점을 수정하는 기능
    public void changeReview(String reviewText, int grade) {
        this.reviewText = reviewText;
        this.grade = grade;
    }

    public void setCustomer(Long customerNo) {
        this.customer = Customer.builder().customerNo(customerNo).build();
    }

    public void setStore(Long storeNo) {
        this.store = Store.builder().storeId(storeNo).build();
    }

}
