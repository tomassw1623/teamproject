package org.crm.crmproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.CustomerRepository;
import org.crm.crmproject.service.CustomerService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
@Log4j2
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    //  고객 회원가입
    @GetMapping("/join")
    public void customerJoinGet() {
        log.info("----- 고객이 가입하다 겟방식 -----");
    }

    @PostMapping("/join")
    public String customerJoinPost(CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {

        log.info("----- 고객이 가입하다 포스트방식 -----");
        log.info(customerDTO);

        try {
            customerService.customerJoin(customerDTO);
        } catch (CustomerService.MidExistException e) {
            redirectAttributes.addFlashAttribute("error", "customerID");
            return "redirect:/customer/join";
        }
        redirectAttributes.addAttribute("result", "success");
        return "redirect:/login";
    }

    //  로그인 시 고객 메인페이지로 이동
    @GetMapping("/main")
    public String customerMain() {
        return "/customer/main";
    }

    //  고객 마이페이지로 이동
    @GetMapping("/my_page")
    public String customerMyPage() {
        return "customermypage";
    }


    @GetMapping("/update")
    public void customerUpdateGet(){
        log.info("----- 고객 업데이트 겟또! -----");
    }

    @PostMapping("/update")
    public String customerUpdatePost(@Valid CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {
        log.info("----- 고객 없데이트 포스트! -----" + customerDTO);

        try {
            customerRepository.updateCustomer(passwordEncoder.encode(customerDTO.getCustomerPw()), customerDTO.getCustomerName(), customerDTO.getCustomerEmail(),
                    customerDTO.getCustomerPhone(), customerDTO.getCustomerNick(), customerDTO.getCustomerId());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "cid");
            return "redirect:/customer/update";
        }
        redirectAttributes.addAttribute("result", "success");
        return "redirect:/customer/update";
    }

    @PostMapping("/delete")
    public void ceoDeletePost(@Valid CustomerDTO customerDTO, RedirectAttributes redirectAttributes) {

        log.info("삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제");

        customerService.customerDelete(customerDTO);
    }

}


