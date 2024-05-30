package org.crm.crmproject.service;

import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.dto.CustomerDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CeoService {

    // 아이디 중복확인
    static class MidExistException extends Exception{
        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }

    // 사장 회원가입 서비스
    void ceoJoin(CeoDTO ceoDTO) throws CeoService.MidExistException;

}
