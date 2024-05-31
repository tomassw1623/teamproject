package org.crm.crmproject.controller;

import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.repository.CeoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StoreController {
    private final CeoRepository ceoRepository;

    public StoreController(CeoRepository ceoRepository) {
        this.ceoRepository = ceoRepository;
    }
    @GetMapping("/stores/{ceoId}")
    public String getStorePage(@PathVariable String ceoId, Model model) {
        Ceo ceo = ceoRepository.getWithRoles(ceoId)
                .orElseThrow(() -> new IllegalArgumentException("사장 아이디! : "+ ceoId));
        model.addAttribute("ceo", ceo);
        model.addAttribute("stores", ceo.getStores());
        return "storePage";
    }
}