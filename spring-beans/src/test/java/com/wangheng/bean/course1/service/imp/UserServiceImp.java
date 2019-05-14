package com.wangheng.bean.course1.service.imp;

import com.wangheng.bean.course1.service.UserService;

public class UserServiceImp implements UserService {

    private String username;

    @Override
    public void setName(String name) {
        this.username = name;
    }

    @Override
    public String getName() {
        return this.username;
    }
}
