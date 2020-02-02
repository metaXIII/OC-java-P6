package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.dto.CommentaireDto;
import com.metaxiii.escalade.dto.LongueurDto;
import com.metaxiii.escalade.dto.SearchDto;
import com.metaxiii.escalade.enums.Message;
import com.metaxiii.escalade.model.Commentaire;
import com.metaxiii.escalade.model.Voie;
import com.metaxiii.escalade.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class Site extends AbstractController {
    @Autowired
    private transient IDepartementService departementService;

    @Autowired
    private transient ISiteService siteService;

    @Autowired
    private transient ISecteurService secteurService;

    @Autowired
    private transient ILongueurService longueurService;

    @Autowired
    private transient IVoiesService voiesService;

    @Autowired
    private transient ICommentaireService commentaireService;

    private static final String REDIRECT = "redirect:/details-site/";

    @GetMapping("/search")
    public ModelAndView search(@ModelAttribute("search") SearchDto searchDto, BindingResult result, WebRequest request, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("departement_list", departementService.findAllDepartement());
        modelAndView.addObject("all_secteur_list", secteurService.findAllSecteur());
        modelAndView.addObject("all_type_list", siteService.findAllType());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView searchSite(@ModelAttribute("search") SearchDto searchDto, BindingResult result, WebRequest request, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("departement_list", departementService.findAllDepartement());
        modelAndView.addObject("all_secteur_list", secteurService.findAllSecteur());
        modelAndView.addObject("all_type_list", siteService.findAllType());
        modelAndView.addObject("results", siteService.getResult(searchDto));
        return modelAndView;
    }

    @GetMapping("/details-site/{id}")
    @ResponseBody
    public ModelAndView detailSite(@PathVariable String id) {
        Optional<com.metaxiii.escalade.model.Site> site = siteService.findById(Long.parseLong(id));
        if (site.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("detail");
            List<Voie>   allBySiteId  = voiesService.findAllBySiteId(Integer.parseInt(id));
            site.get().setCotation(siteService.calculateCotation(allBySiteId));
            modelAndView.addObject("site", site.get());
            modelAndView.addObject("longueur", longueurService.findAllBySiteId(Integer.parseInt(id)));
            modelAndView.addObject("voie", allBySiteId);
            modelAndView.addObject("commentaires", commentaireService.findAllBySiteId(Integer.parseInt(id)));
            return modelAndView;
        } else
            return new ModelAndView("404", "msg", Message.SITE_NOT_FOUND.getMsg());
    }


    @PostMapping("/details-site/{id}")
    @ResponseBody
    public ModelAndView addLongueur(@PathVariable String id, @ModelAttribute("longueur") LongueurDto longueurDto) {
        Optional<com.metaxiii.escalade.model.Site> data = siteService.findById(Long.parseLong(id));
        if (data.isPresent()) {
            longueurService.saveLongueur(longueurDto, Integer.parseInt(id));
            return new ModelAndView(REDIRECT + id);
        } else {
            return new ModelAndView("404", "msg", Message.GLOBAL_ERROR.getMsg());
        }
    }

    @PostMapping("/ajouter-commentaire/{id}")
    @ResponseBody
    public ModelAndView addCommentaire(@PathVariable String id, @ModelAttribute("commentaire") CommentaireDto commentaireDto) {
        Optional<com.metaxiii.escalade.model.Site> data = siteService.findById(Long.parseLong(id));
        if (data.isPresent()) {
            commentaireService.save(commentaireDto, Integer.parseInt(id));
            return new ModelAndView(REDIRECT + id);
        }
        return new ModelAndView("redirect:404");
    }

    @PostMapping("/edit-commentaire/{id}")
    @ResponseBody
    public ModelAndView editCommentaire(@PathVariable String id, @ModelAttribute("commentaire") CommentaireDto commentaireDto) {
        Optional<Commentaire> data   = commentaireService.findById(Long.parseLong(id));
        int                   idSite = 0;
        if (data.isPresent()) {
            idSite = commentaireService.edit(commentaireDto).getSiteId();
            return new ModelAndView(REDIRECT + idSite);
        }
        return new ModelAndView("redirect:/404");
    }

    @GetMapping("delete-commentaire/{id}")
    @ResponseBody
    public ModelAndView deleteCommentaire(@PathVariable String id) {
        int                   idSite;
        Optional<Commentaire> data = commentaireService.findById(Long.parseLong(id));
        if (data.isPresent()) {
            idSite = data.get().getSiteId();
            commentaireService.deleteById(Long.parseLong(id));
            return new ModelAndView(REDIRECT + idSite);
        }
        return new ModelAndView("redirect:/404");
    }

}
