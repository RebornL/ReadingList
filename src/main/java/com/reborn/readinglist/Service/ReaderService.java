package com.reborn.readinglist.Service;


import com.reborn.readinglist.Entity.Reader;

import java.util.List;

/*
* 定义用户接口
* */
public interface ReaderService {

    /**
     * 注册用户
     * @param reader
     * @return 注册成功将用户信息返回，否则返回null
     */
    Reader saveReader(Reader reader);

    /**
     * 检查用户名密码是否正确
     * @param username 用户名
     * @param password 密码
     * @return 验证通过则将用户信息返回，否则返回null
     */
    Reader checkLogin(String username,String password);

    List<Reader> getAllReader();
}
