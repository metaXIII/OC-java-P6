package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SiteDto;
import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.User;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISecteurService;
import com.metaxiii.escalade.service.ISiteService;
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

import java.util.HashMap;
import java.util.Map;

@Controller
public class Site {
    @Autowired
    private IDepartementService departementService;

    @Autowired
    private ISiteService siteService;

    @Autowired
    private ISecteurService secteurService;

    @GetMapping("/account/new-site")
    public ModelAndView new_site(@ModelAttribute("site") SiteDto siteDto,
                                 BindingResult result, WebRequest request, Errors errors, Model model) {
        Map<String, Object> datas = new HashMap<>();
        datas.put("form", "new");
        datas.put("secteur_list", secteurService.findAllSecteur());
        datas.put("departement_list", departementService.findAllDepartement());
        return new ModelAndView("site", "datas", datas);
    }


    @PostMapping("/account/new-site")
    @ResponseBody
    public ModelAndView save_site(@ModelAttribute("site") SiteDto siteDto,
                                  BindingResult result, WebRequest request, Errors errors, Model model) {
        Map<String, Object> datas = new HashMap<>();
        datas.put("form", "new");
        datas.put("departement_list", departementService.findAllDepartement());
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            int id = (int) user.getId();
            String redirect = "redirect:/details-site/" + siteService.save(siteDto, id).getId();
            return new ModelAndView(redirect);
        } catch (Exception e) {
            datas.put("msg", e.getMessage());
            return new ModelAndView("site", "datas", datas);
        }
//        return new ModelAndView("details-site", "msg", Message.SAVE_SITE.getMsg());
    }
}
