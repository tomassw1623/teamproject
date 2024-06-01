package org.crm.crmproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {

    private Long storeId;

    private String eventTitle;

    private String eventContent;
}
