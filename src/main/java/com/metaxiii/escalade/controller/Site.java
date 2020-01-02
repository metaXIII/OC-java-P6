package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.LongueurDto;
import com.metaxiii.escalade.dto.SearchDto;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
            return new ModelAndView(redirect, "msg", Message.SAVE_SITE.getMsg());
        } catch (Exception e) {
            datas.put("msg", e.getMessage());
            return new ModelAndView("site", "datas", datas);
        }
    }

    @GetMapping("/search")
    public ModelAndView search(@ModelAttribute("search") SearchDto searchDto,
                               BindingResult result, WebRequest request, Errors errors) {
        Map<String, Object> search_component = new HashMap<>();
        search_component.put("departement_list", departementService.findAllDepartement());
        search_component.put("all_secteur_list", secteurService.findAllSecteur());
        search_component.put("all_type_list", siteService.findAllType());
        return new ModelAndView("search", "search_component", search_component);
    }

    @PostMapping("/search")
    public ModelAndView search_site(@ModelAttribute("search") SearchDto searchDto,
                                    BindingResult result, WebRequest request, Errors errors) {
        Map<String, Object> search_component = new HashMap<>();
        search_component.put("departement_list", departementService.findAllDepartement());
        search_component.put("all_secteur_list", secteurService.findAllSecteur());
        search_component.put("all_type_list", siteService.findAllType());
        search_component.put("results", siteService.getResult(searchDto));
        return new ModelAndView("search", "search_component", search_component);
    }

    @GetMapping("/details-site/{id}")
    @ResponseBody
    public ModelAndView detail_site(@PathVariable String id) {
        Optional<com.metaxiii.escalade.model.Site> data = siteService.findById(Long.parseLong(id));
        return data.map(
                site -> new ModelAndView("detail", "data", site))
                .orElseGet(() -> new ModelAndView("404", "msg", Message.SITE_NOT_FOUND.getMsg()));
    }

    @GetMapping("/details-site/add-longueur-{id}")
    @ResponseBody
    public ModelAndView add_longueur(@PathVariable String id,@ModelAttribute("longueur") LongueurDto longueurDto) {
        Optional<com.metaxiii.escalade.model.Site> data = siteService.findById(Long.parseLong(id));
        if (data.isPresent()) {
        } else {
            return new ModelAndView("404", "msg", Message.GLOBAL_ERROR.getMsg());
        }
        return data.map(
                site -> new ModelAndView("detail", "data", site))
                .orElseGet(() -> new ModelAndView("404", "msg", Message.SITE_NOT_FOUND.getMsg()));
    }
}
