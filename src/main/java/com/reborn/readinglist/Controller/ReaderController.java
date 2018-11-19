package com.reborn.readinglist.Controller;

import com.reborn.readinglist.Entity.Reader;
import com.reborn.readinglist.Service.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderServiceImpl readerService;

    @GetMapping(value = "/login")
    public String readerLoginPage(HttpSession session, Model model) {
        System.out.println(session.getId());
        System.out.println(session.getAttribute("reader"));
        model.addAttribute("reader", new Reader());
        return "login";
    }

    //登录功能
    @RequestMapping(value = "/loginaction", method = RequestMethod.POST)
    public ModelAndView readerLogin(@ModelAttribute Reader reader, HttpSession session, Model model) {
//        System.out.println("这里是否有运行");
        if(readerService.checkLogin(reader.getUsername(), reader.getPassword()) != null) {
            //登陆成功
            return new ModelAndView("redirect:/readingList/"+reader.getUsername());
        } else {
            return new ModelAndView("login");
        }
    }

    //注册功能
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute Reader reader, HttpSession session, Model model) {
        //注册新用户
        System.out.println(reader);
        readerService.saveReader(reader);
        session.setAttribute("reader", reader);
        return new ModelAndView("redirect:/readingList/"+reader.getUsername());
    }
}
