package com.metaxiii.escalade.controller;

import com.metaxiii.escalade.enums.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class Index extends AbstractController implements ErrorController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView("index");
        if (this.getUser() != null) {
            String msg = Message.BONJOUR.getMsg() + getUser().getUsername();
            modelAndView.addObject("msg", msg);
        }
        return modelAndView;
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return "404";
    }

}
