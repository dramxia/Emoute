package com.ldzy.service.impl;

import com.github.pagehelper.Page;
import com.ldzy.dao.BookDao;
import com.ldzy.domain.Book;
import com.ldzy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDao bookDao;
    @Override
    public Page<Book> findByBookWithUpLoadTimeDesc(Book book) {
        return bookDao.findByBookWithUpLoadTimeDesc(book);
    }

    @Override
    public int edit(Book book) {
        return bookDao.edit(book);
    }
}
