package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusReviewRepository extends JpaRepository<Customer, Long> {


}
