package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ITopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

@Controller
public class Topo {
    @Autowired
    private ITopoService topoService;

    @Autowired
    private IDepartementService departementService;

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

    @GetMapping("/account/new-topo")
    public ModelAndView newTopo(Model model) {
        ModelAndView modelAndView = new ModelAndView("topo");
        modelAndView.addObject("show", true);
        modelAndView.addObject("departement_list", departementService.findAllDepartement());
        return modelAndView;
    }

    @PostMapping("/account/new-topo")
    public ModelAndView saveTopo(Model model, @ModelAttribute("site") TopoDto topoDto) throws ParseException {
        topoService.save(topoDto);
        String msg = "Merci pour votre participation";
        return new ModelAndView("index", "msg", msg);
    }
}
