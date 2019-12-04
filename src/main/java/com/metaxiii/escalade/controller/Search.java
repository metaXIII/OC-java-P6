package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.service.IDepartementService;
import com.metaxiii.escalade.service.ISecteurService;
import com.metaxiii.escalade.service.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        if (searchDto.getElement().equalsIgnoreCase("site")) {
            if (searchDto.getSecteur() != 0)
                return siteService.findAllBySecteur(searchDto.getSecteur());
            else if (searchDto.getDepartement() != 0)
                return siteService.findAllByDepartement(searchDto.getDepartement());
            else if (!searchDto.getType().isEmpty())
                return siteService.findAllByType(searchDto.getType());
            else if (searchDto.isOfficiel())
                return siteService.findAllByOfficiel();
            else
                return siteService.findAllSite();
        }
        //todo pour topos
        else
            return siteService.findAllType();
    }
}
