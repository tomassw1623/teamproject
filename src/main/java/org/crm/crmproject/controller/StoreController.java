package org.crm.crmproject.controller;

import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.domain.Store;
import org.crm.crmproject.repository.CeoRepository;
import org.crm.crmproject.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {
    private final CeoRepository ceoRepository;
    private final StoreService storeService;

    public StoreController(CeoRepository ceoRepository, StoreService storeService) {
        this.ceoRepository = ceoRepository;
        this.storeService = storeService;
    }
    @GetMapping("/{ceoId}")
    public String getStorePage(@PathVariable String ceoId, Model model) {
        Ceo ceo = ceoRepository.getWithRoles(ceoId)
                .orElseThrow(() -> new IllegalArgumentException("사장 아이디! : "+ ceoId));
        model.addAttribute("ceo", ceo);
        model.addAttribute("store", ceo.getStore());
        return "/store/storePage";
    }
    @PostMapping("/{ceoId}2")
    public String createEvent(@PathVariable String ceoId, @RequestParam String eventTitle,
                              @RequestParam String eventContent) {
        storeService.createEvent(ceoId, eventTitle, eventContent);
        return "redirect:/";
    }
    @GetMapping("/{ceoId}2")
    public String getEvent(@PathVariable String ceoId, Model model) {
        List<Store> stores = storeService.getStoresByCeoId(ceoId);
        model.addAttribute("stores", stores);
        return "redirect:/";

    }

}