package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.Site;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISecteurService;
import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class Search {
    @Autowired
    private ISiteService siteService;

    @Autowired
    private ISecteurService secteurService;

    @Autowired
    private IDepartementService departementService;

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
        Optional<Site> data = siteService.findById(Long.parseLong(id));
        return data.map(site -> new ModelAndView("detail", "data", site))
                .orElseGet(() -> new ModelAndView("404", "msg", Message.SITE_NOT_FOUND.getMsg()));
    }
}
