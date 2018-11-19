package com.reborn.readinglist.Service;

import com.reborn.readinglist.Entity.Book;
import com.reborn.readinglist.Entity.Reader;

import java.util.List;

public interface ReadingListService {

    /**
     * 添加书单
     * @param book
     * @return 添加成功将书本信息返回，否则返回null
     */
    Book saveBook(Book book);

    /**
     * 获取用户记录的书单
     * @param readername
     * @return 成功则将书本信息列表返回，否则返回null
     */
    List<Book> getBookList(String readername);

    /**
     * 删除书本卡片
     * @param bookID
     * @return 成功则将书本信息列表返回，否则返回null
     */
    Book deleteBook(long bookID);
}
