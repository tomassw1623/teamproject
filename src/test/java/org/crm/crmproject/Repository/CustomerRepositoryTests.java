package org.crm.crmproject.Repository;

import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Customer;

import org.crm.crmproject.domain.Role;
import org.crm.crmproject.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.stream.LongStream;

@Log4j2
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void InsertCustomerTests(){
        LongStream.range(1,10).forEach(i ->{
            Customer customer = Customer.builder()
                    .customerId("고객아이디" + i)
                    .customerPw(passwordEncoder.encode("1111"))
                    .customerName("고객이름")
                    .customerGender("고객성별")
                    .customerEmail("고객@이메일")
                    .customerPhone("01012341234")
                    .customerNick("고객닉")
                    .build();
            customer.addRole(Role.CUSTOMER);

            customerRepository.save(customer);
        });
    }

    @Test
    public void testRead() {

        Optional<Customer> result = customerRepository.getWithRoles("customer");

        Customer customer = result.orElseThrow();

        log.info(customer);
        log.info(customer.getRoleSet());

        customer.getRoleSet().forEach(role -> log.info(role.name()));
    }

    @Test
    public void testDelete() {

        String customerPw = customerRepository.findCustomerPwByCustomerId("고객아이디5");

        String rawPassword = "111342ㅁㄷㄴㅇㄹ11";

        log.info("db비번 : " + customerPw);
        log.info("입력한거 : " + rawPassword);

        if (customerPw != null && passwordEncoder.matches(rawPassword, customerPw)) {

            customerRepository.customerDelete("고객아이디5");
        } else {

            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
