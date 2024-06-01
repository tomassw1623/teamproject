package org.crm.crmproject.Repository.review;

import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.repository.CusReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class CusReviewTests {
    //  CustomerReivew 임시 테스트
    @Autowired
    private CusReviewRepository cusReviewRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).mapToObj(i -> {

            String customerId = "test Id" + i;
            String customerNick = "test nick" + i;

            return Customer.builder()
                    .customerId(customerId)
                    .customerPw("1111")
                    .customerNick(customerNick)
                    .build();
        })
                .forEach(cusReviewRepository :: save);
    }
}
