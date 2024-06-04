package org.crm.crmproject.dto;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.crm.crmproject.domain.Menu;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {

    private Long sales_id;

    private Long quantity;

    private LocalDateTime sale_date;

    private Menu menu;

}
