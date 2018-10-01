package com.reborn.readinglist.Controller;


import com.reborn.readinglist.Entity.Book;
import com.reborn.readinglist.Entity.Reader;
import com.reborn.readinglist.Repository.ReaderRepository;
import com.reborn.readinglist.Repository.ReadingListRepository;
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
    private ReadingListRepository readingListRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private AmazonProperties amazonProperties;

//    @Autowired
//    public ReadingListController(ReadingListRepository readingListRepository,
//                                 AmazonProperties amazonProperties) {
//        this.readingListRepository = readingListRepository;
//        this.amazonProperties = amazonProperties;
//    }


//    public void setAssociateId(String associateId) {
//        this.associateId = associateId;
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String readersBooks(Reader reader, Model model) {
//        System.out.println(amazonProperties.getAssociatedId());
//        List<Book> readingList = readingListRepository.findByReader(reader);
//
//        if (readingList != null) {
//            model.addAttribute("books", readingList);
//            model.addAttribute("reader",reader);
//            model.addAttribute("amazonID", amazonProperties.getAssociatedId());//将associateID放入模型中
//        }
//
//        return "readingList";
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public String addToReadingList(Reader reader, Book book) {
//        book.setReader(reader);
//        readingListRepository.save(book);
//        return "redirect:/readingList";
//    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader, Model model) {
//        Reader reader1 = readerRepository.getOne(reader);
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader",reader);
            model.addAttribute("amazonID", amazonProperties.getAssociatedId());//将associateID放入模型中
            Book book = new Book();
            book.setReader(reader);
            model.addAttribute("bookEntity", book);
        }

        return "/readingList";//返回readingList这个展示界面
    }

    @RequestMapping(value = "/mark", method = RequestMethod.POST)
    public String addToReadingList(Book bookEntity) {//@PathVariable("reader") String reader,
        //将请求正文中数据绑定到book中
        System.out.println(bookEntity);
//        Reader reader1 = readerRepository.getOne(bookEntity.getReader());
//        bookEntity.setReader(reader);
        readingListRepository.save(bookEntity);
        return "redirect:/readingList/"+bookEntity.getReader();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteReadingList(@PathVariable long id) {//@PathVariable("reader") String reader,
        //将请求正文中数据绑定到book中
        System.out.println(id);
        Book bookEntity = readingListRepository.getOne(id);
        System.out.println(bookEntity);
//        Reader reader1 = readerRepository.getOne(bookEntity.getReader());
//        bookEntity.setReader(reader);
        readingListRepository.delete(bookEntity);
        return "redirect:/readingList/"+bookEntity.getReader();
    }
}
