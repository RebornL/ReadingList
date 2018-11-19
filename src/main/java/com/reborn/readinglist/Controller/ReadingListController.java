package com.reborn.readinglist.Controller;


import com.reborn.readinglist.Entity.Book;
import com.reborn.readinglist.Service.ReadingListServiceImpl;
import com.reborn.readinglist.config.AmazonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {

    @Autowired
    private ReadingListServiceImpl readingListService;

    @Autowired
    private AmazonProperties amazonProperties;

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String readername, Model model) {
//        Reader reader1 = readerRepository.getOne(reader);
        List<Book> readingList = readingListService.getBookList(readername);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader",readername);
            model.addAttribute("amazonID", amazonProperties.getAssociatedId());//将associateID放入模型中
            Book book = new Book();
            book.setReader(readername);
            model.addAttribute("bookEntity", book);
        }

        return "/readingList";//返回readingList这个展示界面
    }

    //mark接口添加书本记录
    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    public String addToReadingList(Book bookEntity) {//@PathVariable("reader") String reader,
        //将请求正文中数据绑定到book中
        System.out.println(bookEntity);
//        Reader reader1 = readerRepository.getOne(bookEntity.getReader());
//        bookEntity.setReader(reader);
        readingListService.saveBook(bookEntity);
        return "redirect:/readingList/"+bookEntity.getReader();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteReadingList(@PathVariable long id) {//@PathVariable("reader") String reader,
        //将请求正文中数据绑定到book中
        System.out.println(id);
//        Book bookEntity = readingListRepository.getOne(id);
//        System.out.println(bookEntity);
//        Reader reader1 = readerRepository.getOne(bookEntity.getReader());
//        bookEntity.setReader(reader);
        Book bookEntity = readingListService.deleteBook(id);
        if(bookEntity != null) return "redirect:/readingList/"+bookEntity.getReader();
        else return "redirect:/readingList/login";
    }
}
