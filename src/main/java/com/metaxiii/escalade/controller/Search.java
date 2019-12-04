package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISecteurService;
import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Search {
    @Autowired
    private ISiteService siteService;

    @Autowired
    private ISecteurService secteurService;

    @Autowired
    private IDepartementService departementService;

    @RequestMapping("/search")
    public ModelAndView search(Model model, @ModelAttribute("search") SearchDto searchDto,
                               BindingResult result, WebRequest request, Errors errors) {
        Map<String, Object> search_component = new HashMap<>();
        search_component.put("departement_list", departementService.findAllDepartement());
        search_component.put("all_secteur_list", secteurService.findAllSecteur());
        search_component.put("all_type_list", siteService.findAllType());
        return new ModelAndView("search", "search_component", search_component);
    }

    @PostMapping("/search")
    public String search_site(Model model, @ModelAttribute("search") SearchDto searchDto,
                              BindingResult result, WebRequest request, Errors errors) {
        model.addAttribute("departements", departementService.findAllDepartement());
        if (searchDto.getElement().equals("site") && searchDto.getSecteur().isEmpty()
                && searchDto.getDepartement() == 0 && searchDto.getType().isEmpty()) {
            model.addAttribute("results", siteService.findAllSite());
        } else {
            //Conditionnal request
        }
        return "search";
    }
}
