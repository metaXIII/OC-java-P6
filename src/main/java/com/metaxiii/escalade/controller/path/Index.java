package com.metaxiii.escalade.controller.path;

import com.metaxiii.escalade.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.metaxiii.escalade.controller.*;

@Controller
public class Index extends AbstractState{

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }
}
