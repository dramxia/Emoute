package com.ldzy.controller;

import com.ldzy.domain.User;
import com.ldzy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "forward:/admin/login.jsp";
    }

    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session){
        System.out.println("login");
        User user1=userService.findByUser(user);
        System.out.println(user1);
        if(user1!=null)  {
            session.setAttribute("user",user1);
            return "forward:/admin/main.jsp";
        }
        else {
            model.addAttribute("msg","您输入的账号或密码不正确！");
            return "forward:/admin/login.jsp";
        }
    }
}
