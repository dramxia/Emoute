package com.ldzy.service;

import com.github.pagehelper.Page;
import com.ldzy.domain.Book;


public interface BookService {
    public Page<Book> findByBookWithUpLoadTimeDesc(Book book);
    public int edit(Book book);

}
