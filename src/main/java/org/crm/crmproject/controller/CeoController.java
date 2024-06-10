package org.crm.crmproject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Menu;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.repository.CeoRepository;

import org.crm.crmproject.repository.MenuRepository;
import org.crm.crmproject.service.member.CeoService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ceo")
@Log4j2
@RequiredArgsConstructor
public class CeoController {

    private final CeoService ceoService;
    private final CeoRepository ceoRepository;
    private final PasswordEncoder passwordEncoder;
    private final MenuRepository menuRepository;

    //  사장 회원가입
    @GetMapping("/join")
    public void ceoJoinGet() {
        log.info("----- 사장이 가입하다 겟방식 -----");
    }

    @PostMapping("/join")
    public String ceoJoinPost(CeoDTO ceoDTO, RedirectAttributes redirectAttributes) {

        log.info("----- 사장이 가입하다 포스트방식 -----");
        log.info(ceoDTO);

        try {
            ceoService.ceoJoin(ceoDTO);
        } catch (CeoService.MidExistException e) {
            redirectAttributes.addFlashAttribute("error", "ceoID");
            return "redirect:/ceo/join";
        }
        redirectAttributes.addAttribute("result", "success");
        return "redirect:/login";
    }

    //  로그인 시 사업자 메인페이지로 이동
    @GetMapping("/main")
    public String ceoMain() {
        return "/ceo/main";
    }

    //  사업자 마이페이지 이동
    @GetMapping("/ceomy_page")
    public String ceoMyPage() {
        return "/ceo/ceomy_page";
    }

    // 이벤트 글 이동
    @GetMapping("/event")
    public String ceoEvent() {
        return "/ceo/event";
    }

    @GetMapping("/update")
    public void ceoUpdateGet(){
        log.info("----- 사장 업데이트 겟또! -----");

    }

//    @PostMapping("/update")
//    public String ceoUpdatePost(@Valid CeoDTO ceoDTO, RedirectAttributes redirectAttributes) {
//        log.info("----- 사장 업데이트 포스트! -----" + ceoDTO);
//
//        try {
//            ceoRepository.updateCeo(passwordEncoder.encode(ceoDTO.getCeoPw()), ceoDTO.getCeoName(), ceoDTO.getCeoEmail(),
//                    ceoDTO.getCeoPhone(), ceoDTO.getStoreAddress(), ceoDTO.getCeoId());
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("error", "cid");
//            return "redirect:/ceo/update";
//        }
//        redirectAttributes.addAttribute("result", "success");
//        return "redirect:/ceo/update";
//    }


    @PostMapping("/delete")
    @ResponseBody
    public Map<String, Object> ceoDeletePost(@RequestParam("ceoPw") String ceoPw, @RequestParam("ceoId") String ceoId) {

        Map<String, Object> response = new HashMap<>();

        log.info(ceoId);
        log.info(ceoPw);

        log.info("삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제삭제");

//        boolean isDeleted = ceoService.ceoDelete(ceoId, ceoPw);
//
//        log.info(isDeleted);
//
//        if (isDeleted) {
//            response.put("success", true);
//            response.put("message", "회원 탈퇴가 성공적으로 처리되었습니다.");
//        } else {
//            response.put("success", false);
//            response.put("message", "회원 탈퇴에 실패하였습니다.");
//        }

        return response;
    }

    //그래프작업을 위해서 이곳에 컨트롤러를 작성합니다
    @GetMapping("/mainPage")
    public String mainPage(Model model){
        List<Menu> menus = menuRepository.findAll();
        model.addAttribute("menus",menus);
        return "/ceo/main";
    }


}







