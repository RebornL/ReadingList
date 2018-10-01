package com.reborn.readinglist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
//        model.
        model.addAttribute("title", "阅读者清单");
        model.addAttribute("name", "读书记录");
        return "index";
    }
}
