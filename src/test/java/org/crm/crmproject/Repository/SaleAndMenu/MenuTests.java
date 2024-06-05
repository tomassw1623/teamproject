package org.crm.crmproject.Repository.SaleAndMenu;

import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.domain.Menu;
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


        //ceo 가입하고 하면 값이 들어갑니다
    //레파지토리는 ceo no 을 가지고오고싶어서 다시 만들었습니다
    @Test
    public void insertTest(){
        Ceo ceo = ceoRepository_longType.findById(1L).orElse(null);//
        Menu menu = Menu.builder()
                .Menu_price(10000L).menu_name("라면").menu_id(2L).ceo(ceo).
                build();

        menuRepository.save(menu);
    }


}
