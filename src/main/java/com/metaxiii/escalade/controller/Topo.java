package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.service.ITopoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class Topo {
    private final ITopoService topoService;

    @RequestMapping("/topo")
    public ModelAndView topo() {
        ModelAndView modelAndView = new ModelAndView("topo");
        modelAndView.addObject("results", topoService.findAllTopos());
        modelAndView.addObject("show", false);
        return modelAndView;
    }

    @GetMapping("/reservation-topo/{id}")
    @ResponseBody
    public ModelAndView reservation(@PathVariable String id) {
        String msg = topoService.updateTopoWithId(id);
        return new ModelAndView("index", "msg", msg);
    }
}
