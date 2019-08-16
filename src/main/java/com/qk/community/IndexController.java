package com.qk.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class IndexController {

    @GetMapping("/")
    public String greeting(@RequestParam(name="name",required = false,defaultValue = "World") String name,Model model){
        model.addAttribute("name", name);
        return "index";
    }
}


