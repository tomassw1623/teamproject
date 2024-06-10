//package org.crm.crmproject.Repository.SaleAndMenu;
//
//import org.crm.crmproject.domain.Menu;
//import org.crm.crmproject.domain.Sales;
//import org.crm.crmproject.repository.MenuRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.time.LocalDateTime;
//
//
//@SpringBootTest
//public class SalesTests {
//
//    @Autowired
//    private MenuRepository menuRepository;
//
//    @Test
//    public void InsertTestSales(){
//        Menu menu = menuRepository.findById(1L).orElse(null);
//        Sales sales = Sales.builder()
//                .sales_id(1L)
//                .menu(menu)
//                .quantity(2L)
//                .sale_date(LocalDateTime.now()).build();
//        salesRepository.save(sales);
//        }
//
//}
