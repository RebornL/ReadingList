package com.reborn.readinglist.Repository;

import com.reborn.readinglist.Entity.Book;
import com.reborn.readinglist.Entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
    //只需要定义接口，SpringBoot会自动实现
    List<Book> findByReader(String readername);
    Book deleteById(long id);
//    Book findById(Long id);
}
