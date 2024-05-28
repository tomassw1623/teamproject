package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Review;
import org.crm.crmproject.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/star")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/review")
    public String goReview() {
        return "/star/review";
    }

    @ResponseBody
    @PostMapping("/review")
    public Review saveReview(@RequestBody Review review){
        return reviewRepository.save(review);
    }
}
