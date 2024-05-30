package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.repository.CeoRepository;
import org.crm.crmproject.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static jakarta.persistence.GenerationType.UUID;

@Service
@RequiredArgsConstructor
@Log4j2

public class CeoServiceImpl implements CeoService{

    private final CeoRepository ceoRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    // ceo 회원가입
    @Override
    public void ceoJoin(CeoDTO ceoDTO) throws CeoService.MidExistException {

        String id = ceoDTO.getCeoId();

        // 아이디 중복확인
        boolean exist = ceoRepository.existsByCeoId(id);

        boolean exist2 = customerRepository.existsByCustomerId(id);

        if(exist || exist2) {
            throw new CeoService.MidExistException();
        }

        // DTO 에서 비밀번호 가져오기
        String rawPassword = ceoDTO.getCeoPw();

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // 암호화된 비밀번호를 DTO 에 다시 설정
        ceoDTO.setCeoPw(encodedPassword);

        Ceo ceo = modelMapper.map(ceoDTO, Ceo.class);

        ceoRepository.save(ceo);
    }



}
