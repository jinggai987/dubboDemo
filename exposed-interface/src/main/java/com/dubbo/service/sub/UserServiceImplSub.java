package com.dubbo.service.sub;

import com.dubbo.bean.UserAddress;
import com.dubbo.service.UserService;

import java.util.List;

public class UserServiceImplSub implements UserService{

    private final UserService userService;

    public UserServiceImplSub(UserService userService) {
        super();
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        try {
            System.out.println("走进本地存根。。。");
            return userService.getUserAddressList(userId);
        } catch (Exception e) {
            return null;
        }
    }

}
