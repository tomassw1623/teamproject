package org.crm.crmproject.Repository;

import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Store;
import org.crm.crmproject.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class StoreRepositoryTests {

    @Autowired
    private StoreRepository storeRepository;

    @Test
    public void testStoreInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {

            Store store = Store.builder()
                    .eventTitle("test title" + i)
                    .eventContent("test content" + i)
                    .build();

            storeRepository.save(store);
        });
    }
}
