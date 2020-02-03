package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.Reservation;
import com.metaxiii.escalade.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class Account extends AbstractController {

    private final transient IDepartementService departementService;

    private final transient ISiteService siteService;

    private final transient ISecteurService secteurService;

    private final transient IReservationService reservationService;

    private final transient ITopoService topoService;

    @GetMapping("/account")
    public ModelAndView account() {
        ModelAndView modelAndView = new ModelAndView("account");
        modelAndView.addObject("reservations", reservationService.findAllReservationByUserId(getUser().getId()));
        modelAndView.addObject("topoList", topoService.findAllByUserId(getUser().getId()));
        return modelAndView;
    }

    @GetMapping("/account/reservations/unsuscribe/{id}")
    @ResponseBody
    public ModelAndView unsubscribeReservation(@PathVariable String id) {
        reservationService.completeReservation(Long.parseLong(id));
        return new ModelAndView("redirect:/account");
    }


    @GetMapping("/account/new-site")
    public ModelAndView newSite(@ModelAttribute("site") SiteDto siteDto) {
        ModelAndView modelAndView = new ModelAndView("site");
        modelAndView.addObject("form", "new");
        modelAndView.addObject("secteurList", secteurService.findAllSecteur());
        modelAndView.addObject("departement_list", departementService.findAllDepartement());
        return modelAndView;
    }

    @PostMapping("/account/new-site")
    @ResponseBody
    public ModelAndView saveSite(@ModelAttribute("site") SiteDto siteDto) {
        try {
            String redirect = "redirect:/details-site/" + siteService.save(siteDto, getUser().getId()).getId();
            return new ModelAndView(redirect, "msg", Message.SAVE_SITE.getMsg());
        } catch (Exception e) {
            return newSite(siteDto);
        }
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


    @GetMapping("/account/reservations")
    @ResponseBody
    public ModelAndView getReservationList() {
        ModelAndView      modelAndView = new ModelAndView("account");
        List<Reservation> findAll      = reservationService.findAllReservationByUserId(getUser().getId());
        modelAndView.addObject("show", true);
        modelAndView.addObject("reservations", findAll);
        return modelAndView;
    }

    @GetMapping("/account/changestate/{id}")
    @ResponseBody
    public ModelAndView changeState(@PathVariable String id)
    {
        topoService.setAvailable(Long.parseLong(id));
        return new ModelAndView("redirect:/account");
    }
}
