package org.crm.crmproject.service.member;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Customer;
import org.crm.crmproject.dto.CustomerDTO;
import org.crm.crmproject.repository.CeoRepository;
import org.crm.crmproject.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor

public class CustomerServiceImpl implements CustomerService{

    private final CeoRepository ceoRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void customerJoin(CustomerDTO customerDTO) throws CustomerService.MidExistException {

        String id = customerDTO.getCustomerId();

        // 아이디 중복 확인
        boolean exist = ceoRepository.existsByCeoId(id);

        boolean exist2 = customerRepository.existsByCustomerId(id);

        if(exist || exist2) {
            throw new CustomerService.MidExistException();
        }
        // DTO 에서 비밀번호 가져오기
        String rawPassword = customerDTO.getCustomerPw();

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 암호화된 비밀번호를 DTO 에 다시 설정
        customerDTO.setCustomerPw(encodedPassword);

        Customer customer = modelMapper.map(customerDTO, Customer.class);

        customerRepository.save(customer);

        log.info("커스터머 가입 성공적");

    }

    @Override
    public void customerDelete(CustomerDTO customerDTO) {

        String customerPw = customerRepository.findCustomerPwByCustomerId(customerDTO.getCustomerId());

        String rawPassword = customerDTO.getCustomerPw();

        if (customerPw != null && passwordEncoder.matches(rawPassword, customerPw)) {

            customerRepository.customerDelete(customerDTO.getCustomerId());
        } else {

            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
