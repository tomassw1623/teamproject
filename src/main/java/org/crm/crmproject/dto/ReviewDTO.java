package org.crm.crmproject.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    private Long reviewNo;

    private String reviewText;

    private int grade;



}
