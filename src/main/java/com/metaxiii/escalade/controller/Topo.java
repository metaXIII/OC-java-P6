package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.service.ITopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Topo {
    @Autowired
    private ITopoService topoService;

    @RequestMapping("/topo")
    public ModelAndView topo() {
        return new ModelAndView("topo", "results", topoService.findAllTopos());
    }
}
