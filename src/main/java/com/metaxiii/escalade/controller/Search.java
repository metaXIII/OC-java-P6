package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Search  {
    @Autowired
    private ISiteService siteService;
    @RequestMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("/search")
    public ModelAndView search_site() {
        return new ModelAndView("search", "result", siteService.findAllSite());
    }
}
