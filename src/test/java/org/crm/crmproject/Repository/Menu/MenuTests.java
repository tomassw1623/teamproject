package org.crm.crmproject.Repository.Menu;

import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.domain.Menu;
import org.crm.crmproject.repository.CeoRepository;
import org.crm.crmproject.repository.CeoRepository_LongType;
import org.crm.crmproject.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuTests {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private CeoRepository_LongType ceoRepository_longType;



    @Test
    public void insertTest(){
        Ceo ceo = ceoRepository_longType.findById(1L).orElse(null);//
        Menu menu = Menu.builder()
                .Menu_price(200L).menu_name("파스타").menu_id(1L).ceo(ceo).
                build();

        menuRepository.save(menu);
    }


}
