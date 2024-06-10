package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.dto.CeoDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CeoRepository extends JpaRepository<Ceo, Long> {
    // 로그인시 아이디와 권한 확인용
    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Ceo m where m.ceoId = :ceoId")
    Optional<Ceo> getWithRoles(String ceoId);
    // 아이디 중복 확인
    boolean existsByCeoId (String ceoId);

    // 회원 정보 수정
    @Modifying
    @Transactional
    @Query("update Ceo c set c.ceoPw = :re_pw, c.ceoName = :re_name, c.ceoEmail = :re_email, " +
            "c.ceoPhone = :re_phone, c.storeAddress = :re_address where c.ceoId = :ceo_id")

    void updateCeo(@Param("re_pw") String pw, @Param("re_name")String name, @Param("re_email")String email,
                   @Param("re_phone")String phone, @Param("re_address")String address, @Param("ceo_id")String id );

    // 비밀번호 가져오기
    @Query("select c.ceoPw from Ceo c where c.ceoId = :ceoId")
    String findCeoPwByCeoId(@Param("ceoId") String ceoId);

    // db 삭제
    @Modifying
    @Transactional
    @Query("delete from Ceo m where m.ceoId = :ceoId")
    void ceoDelete(@Param("ceoId") String ceoId);

    Optional<Ceo> findByCeoNo(Long ceoNo);
}