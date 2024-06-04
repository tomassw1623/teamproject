package org.crm.crmproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Menu {

    @Id
    private Long menu_id;

    private String menu_name;

    private Long Menu_price;

    @ManyToOne
    private Ceo ceo_No;


}
