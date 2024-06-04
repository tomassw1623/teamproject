package org.crm.crmproject.dto;


import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.crm.crmproject.domain.Ceo;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MenuDTO {


    private Long menu_id;

    private String menu_name;

    private Long Menu_price;

    private Ceo ceo_No;
}
