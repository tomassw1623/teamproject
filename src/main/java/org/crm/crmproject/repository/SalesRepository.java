package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Long, Sales> {
}
