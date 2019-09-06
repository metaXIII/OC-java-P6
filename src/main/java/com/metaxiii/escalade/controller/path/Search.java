package com.metaxiii.escalade.controller.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Search {
    @RequestMapping("/search")
    public String search() {
        return "search";
    }
}
