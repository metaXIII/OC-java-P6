package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISecteurService;
import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        search_component.put("results", getResult(searchDto));
        return new ModelAndView("search", "search_component", search_component);
    }

    private Object getResult(SearchDto searchDto) {
        int secteur = searchDto.getSecteur();
        int departement = searchDto.getDepartement();
        String type = searchDto.getType();
        boolean officiel = searchDto.isOfficiel();
        if (secteur != 0 && departement == 0 && type.isEmpty() && !officiel)
            return siteService.findAllBySecteur(searchDto.getSecteur());
        else if (secteur == 0 && departement != 0 && type.isEmpty() && !officiel)
            return siteService.findAllByDepartement(searchDto.getDepartement());
        else if (secteur == 0 && departement == 0 && !type.isEmpty() && !officiel)
            return siteService.findAllByType(searchDto.getType());
        else if (secteur == 0 && departement == 0 && type.isEmpty() && officiel)
            return siteService.findAllByOfficiel();
        else {
            return siteService.findAllByParam(
                    getSQLParam(secteur),
                    getSQLParam(departement),
                    getSQLParam(type),
                    getSQLParam(officiel)
            );
        }
    }

    private String getSQLParam(int element) {
        if (element == 0)
            return "%";
        return String.valueOf(element);
    }

    private String getSQLParam(String element) {
        if (element.isEmpty())
            return "%";
        return element;
    }

    private String getSQLParam(Boolean element) {
        if (!element)
            return "%";
        return "1";
    }
}
