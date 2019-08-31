package com.metaxiii.escalade.controller.path;

import com.metaxiii.escalade.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.metaxiii.escalade.controller.*;

@Controller
public class Index extends AbstractState{
    private User user;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("state", isConnected);
        model.addAttribute("nom", "aze");
        return "index";
    }
}
