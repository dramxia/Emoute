package com.ldzy.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ldzy.domain.Book;
import com.ldzy.domain.Result;
import com.ldzy.domain.ResultCode;
import com.ldzy.domain.User;
import com.ldzy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/selectNewbooks")
    public String selectNewbooks(Model model){
        PageHelper.startPage(1,5);
        Page<Book> books=bookService.findByBookWithUpLoadTimeDesc(null);
        System.out.println(books);
        model.addAttribute("pageResult",books.getResult());
        return "admin/books_new";
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Result<Book> findById(int id){
        Book book=new Book();
        book.setId(id);
        PageHelper.startPage(1,5);
        Page<Book> books=bookService.findByBookWithUpLoadTimeDesc(book);
        Result<Book> result=new Result<Book>(true, ResultCode.SUCCESS.getDesc(),ResultCode.SUCCESS.getCode(),(Book)books.getResult().get(0));
        return result;
    }

    @RequestMapping("/borrowBook")
    @ResponseBody
    public Result borrowBook(Book book, HttpSession session){
        book.setStatus("1");
        User user=(User)session.getAttribute("user");
        book.setBorrower(user.getName());
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        book.setBorrowTime(simpleDateFormat.format(date));
        int i=bookService.edit(book);
        if(i>0){
            return new Result(true, ResultCode.SUCCESS.getDesc(),ResultCode.SUCCESS.getCode());
        }
        return new Result(false, ResultCode.ERROR.getDesc(),ResultCode.ERROR.getCode());
    }
}
