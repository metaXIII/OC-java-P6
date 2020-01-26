package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.dto.TopoDto;
import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.Reservation;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Account extends AbstractController {

    @Autowired
    private IDepartementService departementService;

    @Autowired
    private ISiteService siteService;

    @Autowired
    private ISecteurService secteurService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private ITopoService topoService;

    @GetMapping("/account")
    public ModelAndView account() {
        User         user         = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView("account");
        modelAndView.addObject("reservations", reservationService.findAllReservationByUserId(user.getId()));
        return modelAndView;
    }

    @GetMapping("/account/new-site")
    public ModelAndView new_site(@ModelAttribute("site") SiteDto siteDto,
                                 BindingResult result, WebRequest request, Errors errors, Model model) {
        ModelAndView modelAndView = new ModelAndView("site");
        modelAndView.addObject("form", "new");
        modelAndView.addObject("secteurList", secteurService.findAllSecteur());
        modelAndView.addObject("departement_list", departementService.findAllDepartement());
        return modelAndView;
    }


    @PostMapping("/account/new-site")
    @ResponseBody
    public ModelAndView save_site(@ModelAttribute("site") SiteDto siteDto,
                                  BindingResult result, WebRequest request, Errors errors, Model model) {
        Map<String, Object> datas = new HashMap<>();
        datas.put("form", "new");
        datas.put("departement_list", departementService.findAllDepartement());
        try {
            User   user     = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int    id       = (int) user.getId();
            String redirect = "redirect:/details-site/" + siteService.save(siteDto, id).getId();
            return new ModelAndView(redirect, "msg", Message.SAVE_SITE.getMsg());
        } catch (Exception e) {
            datas.put("msg", e.getMessage());
            return new ModelAndView("site", "datas", datas);
        }
    }



    @GetMapping("/account/reservations")
    @ResponseBody
    public ModelAndView getReservationList(Model model) {
        ModelAndView      modelAndView = new ModelAndView("account");
        List<Reservation> findAll      = reservationService.findAllReservationByUserId(getUser().getId());
        modelAndView.addObject("show", true);
        modelAndView.addObject("reservations", findAll);
        return modelAndView;
    }
}
