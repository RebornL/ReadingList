package com.reborn.readinglist.Service;

import com.reborn.readinglist.Entity.Book;
import com.reborn.readinglist.Repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReadingListService")
public class ReadingListServiceImpl implements ReadingListService {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Override
    public Book saveBook(Book book) {
        return readingListRepository.save(book);
    }

    @Override
    public List<Book> getBookList(String readername) {
        return readingListRepository.findByReader(readername);
    }

    @Override
    public Book deleteBook(long bookID) {
        return readingListRepository.deleteById(bookID);
    }


}
