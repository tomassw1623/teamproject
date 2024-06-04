package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Ceo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CeoRepository_LongType extends JpaRepository<Ceo,Long> {
}
