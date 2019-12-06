package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.service.ITopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Topo {
    @Autowired
    private ITopoService topoService;

    @RequestMapping("/topo")
    public ModelAndView topo() {
        return new ModelAndView("topo", "results", topoService.findAllTopos());
    }

    @GetMapping("/reservation-topo/{id}")
    @ResponseBody
    public ModelAndView reservation(@PathVariable String id) {
        String msg = updateTopoWithId(id);
        return new ModelAndView("index");
    }

    private String updateTopoWithId(String id) {
        try {
            if (topoService.findById(Long.parseLong(id)).isPresent()) {
                topoService.updateAvailableById(Long.parseLong(id), false);
                return "La demande de réservation a bien été effectuée";
            } else {
                return "Une erreur s'est produite, veuillez réessayer plus tard";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Une erreur s'est produite, veuillez réessayer plus tard";
        }
    }
}
