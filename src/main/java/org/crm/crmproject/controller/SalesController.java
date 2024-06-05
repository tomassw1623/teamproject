//package org.crm.crmproject.controller;
//
//import org.crm.crmproject.domain.Sales;
//import org.crm.crmproject.repository.SalesRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/sales")
//public class SalesController {
//
//    private final SalesRepository salesRepository;
//
//    public SalesController(SalesRepository salesRepository){
//        this.salesRepository = salesRepository;
//    }
//
//    @GetMapping("/{menuId}")
//    public ResponseEntity<List<Sales>> getSalesByMenuId(@PathVariable Long menuId) {
//        List<Sales> sales = salesRepository.findByMenuMenu_id(menuId);
//        return ResponseEntity.ok(sales);
//    }
//}
