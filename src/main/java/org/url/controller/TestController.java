package org.url.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test")
    public String test(Model model){
        String img="image/bg3.jpg";
        model.addAttribute("img",img);
        return "test";
    }
}
