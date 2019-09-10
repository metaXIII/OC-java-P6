package com.metaxiii.escalade.controller.path.search;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Site {
    @RequestMapping("/detail")
    public String defaultView() {
        return "detail";
    }
}
