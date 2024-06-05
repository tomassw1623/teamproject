package org.crm.crmproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Sales {

    @Id
    private Long sales_id;

    private Long quantity;

    private LocalDateTime sale_date;

    @OneToOne
    private Menu menu;
}
