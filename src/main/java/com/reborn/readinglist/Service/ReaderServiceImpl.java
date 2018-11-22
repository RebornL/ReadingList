package com.reborn.readinglist.Service;


import com.reborn.readinglist.Entity.Reader;
import com.reborn.readinglist.Repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 用户服务接口实现
* */
@Service("ReaderService")
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    ReaderRepository readerRepository;

    @Override
    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public Reader checkLogin(String username, String password) {
        return readerRepository.findFirstByUsernameAndPassword(username, password);
    }

    @Override
    public List<Reader> getAllReader() {
        return readerRepository.getReaders();
    }
}
