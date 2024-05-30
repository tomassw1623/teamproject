package org.crm.crmproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String url;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CEO_ID")
    private Ceo ceo;

}
