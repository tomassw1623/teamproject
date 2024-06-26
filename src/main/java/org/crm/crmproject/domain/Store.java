package org.crm.crmproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "ceo")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String eventTitle;  //  이벤트 글 제목

    private String eventContent;    //  이벤트 글 내용

    @OneToOne
    @JoinColumn(name = "store_name", referencedColumnName = "store_name")
    private Ceo ceo;



}