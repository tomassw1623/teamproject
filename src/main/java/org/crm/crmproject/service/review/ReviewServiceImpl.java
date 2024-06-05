package org.crm.crmproject.service.review;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.domain.Review;
import org.crm.crmproject.domain.Store;
import org.crm.crmproject.dto.ReviewDTO;
import org.crm.crmproject.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{


}
