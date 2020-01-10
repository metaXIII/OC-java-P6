package com.metaxiii.escalade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Redirect {
    @GetMapping("/redirect-site-{id}")
    public ModelAndView redirectToDetailSite(@PathVariable String id) {
        if (id.equals("0"))
            return new ModelAndView("404");
        return new ModelAndView("redirect:/details-site/" + id);
    }
}
