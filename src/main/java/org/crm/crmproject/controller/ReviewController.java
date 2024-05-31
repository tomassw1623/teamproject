package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.domain.Review;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.CustomerRepository;
import org.crm.crmproject.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/star")
public class ReviewController {

//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    @GetMapping("/review")
//    public String goReview() {
//        return "/star/review";
//    }
//
//    @ResponseBody
//    @PostMapping("/review")
//    public Review saveReview(@RequestBody Review review){
//        return reviewRepository.save(review);
//    }


}
