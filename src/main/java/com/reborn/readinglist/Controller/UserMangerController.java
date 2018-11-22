package com.reborn.readinglist.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class UserMangerController {

    @RequestMapping("/index")
    public String index() {
        return "manager";
    }

}
