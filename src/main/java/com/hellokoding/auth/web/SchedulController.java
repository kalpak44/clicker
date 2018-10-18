package com.hellokoding.auth.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SchedulController {
    @RequestMapping(value = {"/scheduling"}, method = RequestMethod.GET)
    public String scheduling(Model model) {
        return "scheduling";
    }
}
