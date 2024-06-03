package org.crm.crmproject.Repository.review;

import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.domain.Review;
import org.crm.crmproject.domain.Store;
import org.crm.crmproject.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void testReviewInsert() {
        IntStream.rangeClosed(1, 200).forEach(i -> {

            //  가게 번호
            Long storeId = (long)(Math.random()*100)+1;

            //  리뷰 번호
            Long reviewId = ((long)(Math.random()*100) + 1);
            Customer customer = Customer.builder().customerNo(reviewId).build();

            Review storeReview = Review.builder()
                    .customer(customer)
                    .store(Store.builder().storeId(storeId).build())
                    .grade((int)(Math.random()*5)+1)
                    .reviewText("가게에 대한 평점..." + i)
                    .build();

            reviewRepository.save(storeReview);
        });
    }

}
