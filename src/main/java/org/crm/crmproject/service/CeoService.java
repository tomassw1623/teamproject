package org.crm.crmproject.service;

import org.crm.crmproject.dto.CeoDTO;

public interface CeoService {

    // 아이디 중복확인
    static class MidExistException extends Exception{
        public MidExistException() {}
        public MidExistException(String message) {super(message);}
    }

    // 사장 회원가입 서비스
    void ceoJoin(CeoDTO ceoDTO) throws CeoService.MidExistException;

    // 회원 탈퇴
    void ceoDelete(CeoDTO ceoDTO);
}
