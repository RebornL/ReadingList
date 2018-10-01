package com.reborn.readinglist.Controller;

import com.reborn.readinglist.Entity.Reader;
import com.reborn.readinglist.Repository.ReaderRepository;
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
    private ReaderRepository readerRepository;

    @GetMapping(value = "/login")
    public String readerLoginPage(HttpSession session, Model model) {
        System.out.println(session.getId());
        System.out.println(session.getAttribute("reader"));
        model.addAttribute("reader", new Reader());
        return "login";
    }

    @RequestMapping(value = "/loginaction", method = RequestMethod.POST)
    public ModelAndView readerLogin(@ModelAttribute Reader reader, HttpSession session, Model model) {
//        System.out.println("这里是否有运行");
        if(readerRepository.getOne(reader.getUsername()) != null) {
            //用户名存在，判断密码是否正确
            Reader reader1 = readerRepository.getOne(reader.getUsername());
            System.out.println(reader1);
            if(reader1.getPassword().equals(reader.getPassword())) {
//                return "/readingList/"+reader.getUsername();
                session.setAttribute("reader", reader1);
                return new ModelAndView("redirect:/readingList/"+reader.getUsername());
            } else {
                return new ModelAndView("login");
            }
        }
        //注册新用户
        System.out.println(reader);
        readerRepository.save(reader);
        session.setAttribute("reader", reader);
        return new ModelAndView("redirect:/readingList/"+reader.getUsername());
    }
}
