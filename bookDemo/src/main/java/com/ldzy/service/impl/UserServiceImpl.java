package com.ldzy.service.impl;

import com.ldzy.dao.UserDao;
import com.ldzy.domain.User;
import com.ldzy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User findByUser(User user) {
        return userDao.findByUser(user);
    }


}
