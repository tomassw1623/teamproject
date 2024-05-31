package org.crm.crmproject.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long rn;

    private String review;

    private int star;


}
