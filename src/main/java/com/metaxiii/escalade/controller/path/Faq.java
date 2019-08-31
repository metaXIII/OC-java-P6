package com.metaxiii.escalade.controller.path;

import com.metaxiii.escalade.controller.AbstractState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Faq  extends AbstractState {
    @RequestMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("state", isConnected);
        return "faq";
    }
}
