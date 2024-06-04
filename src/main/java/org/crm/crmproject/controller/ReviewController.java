package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.domain.Review;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.dto.ReviewDTO;
import org.crm.crmproject.repository.CustomerRepository;
import org.crm.crmproject.repository.ReviewRepository;
import org.crm.crmproject.service.review.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;


}
