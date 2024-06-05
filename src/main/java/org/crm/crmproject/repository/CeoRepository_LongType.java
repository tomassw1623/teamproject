package org.crm.crmproject.repository;

import org.crm.crmproject.domain.Ceo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//이 레파지토리는 기존ceo 레파지토리가 string타입을 반환해서 Long을 반환하기 위해서 생성했습니다.
@Repository
public interface CeoRepository_LongType extends JpaRepository<Ceo,Long> {
}
