package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Search {
    @Autowired
    private ISiteService siteService;

    @Autowired
    private IDepartementService departementService;

    @RequestMapping("/search")
    public String search(Model model) {
        model.addAttribute("departements", departementService.findAllDepartement());
        return "search";
    }

    @PostMapping("/search")
    public String search_site(Model model) {
        model.addAttribute("results", siteService.findAllSite());
        model.addAttribute("departements", departementService.findAllDepartement());
        return "search";
    }
}
