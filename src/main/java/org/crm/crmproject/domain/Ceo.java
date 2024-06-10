package org.crm.crmproject.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "roleSet")

public class Ceo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ceo_no")
    private Long ceoNo;

    @Column(unique = true, nullable = false)
    private String ceoId;

    @Column(nullable = false)
    private String ceoPw;

    private String ceoName;

    private String ceoEmail;

    private String ceoPhone;

    private String businessNum;

    @Column(name = "store_name", unique = true, nullable = false)
    private String storeName;

    private String storeAddress;

    @OneToOne(mappedBy = "ceo", cascade = CascadeType.PERSIST)
    private Store store;

    // Ceo Entity 를 참조하는 roleSet table 생성용
    @ElementCollection(targetClass = Role.class, fetch = FetchType.LAZY)
    @Builder.Default
//    @JoinTable(name = "ceo_role_set", joinColumns = @JoinColumn(name = "ceo_no"))
//    @Column(name = "role_set")
    @Enumerated(EnumType.STRING)
    private Set<Role> roleSet = new HashSet<>();


    public void addRole(Role role) {
        this.roleSet.add(role);
    }

}