package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.domain.Review;
import org.crm.crmproject.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {



}
