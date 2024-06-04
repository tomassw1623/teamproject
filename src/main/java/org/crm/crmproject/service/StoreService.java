package org.crm.crmproject.service;

import lombok.RequiredArgsConstructor;
import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.domain.Store;
import org.crm.crmproject.repository.CeoRepository;
import org.crm.crmproject.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
// ** 스토어 기능 이벤트글밖에 없어 임플 따로 안만들었습니다.
@Service
@RequiredArgsConstructor
public class StoreService {

    private final CeoRepository ceoRepository;
//    private final StoreRepository storeRepository;

    @Transactional
    public void createEvent(String ceoId, String eventTitle, String eventContent) {
        Ceo ceo = ceoRepository.getWithRoles(ceoId).orElseThrow(() -> new IllegalArgumentException("Invalid Ceo ID"));
        Store store = Store.builder()
                .eventTitle(eventTitle)
                .eventContent(eventContent)
                .ceo(ceo)
                .build();
        ceo.setStore(store);

        ceoRepository.save(ceo);
    }

    public List<Store> getStoresByCeoId(String ceoId) {
        Ceo ceo = ceoRepository.findById(ceoId).orElseThrow(() -> new IllegalArgumentException("Invalid Ceo ID"));
        return List.of(ceo.getStore());
    }
}
