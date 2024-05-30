package org.crm.crmproject.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class LoginController {  // login.html 로 이동하는 용도

    @GetMapping("/login")
    public void loginGET(String error, String logout) {
        log.info("로그인을 한다");
        log.info("로그아웃 : " + logout);

        if (logout != null) {
            log.info("로그아웃을 한다");
        }
    }

    // 스프링 시큐리티 설정도 해줘야 됨.
//    @PostMapping("/login")
//    public void login(String username, String password) {
//
//    }
//}
}