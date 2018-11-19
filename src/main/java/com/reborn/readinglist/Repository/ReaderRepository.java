package com.reborn.readinglist.Repository;

import com.reborn.readinglist.Entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReaderRepository extends JpaRepository<Reader, String> {
    //只需要定义接口，SpringBoot会自动实现
    Reader findFirstByUsernameAndPassword(String username, String password);
}
