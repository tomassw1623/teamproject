package org.crm.crmproject.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/main")
public class MainController {

    @GetMapping("/board")
    public String goMian(){
        return "/board";
    }

}
