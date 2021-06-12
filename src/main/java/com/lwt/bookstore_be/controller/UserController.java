package com.lwt.bookstore_be.controller;

import com.lwt.bookstore_be.constant.Constant;
import com.lwt.bookstore_be.entity.BookEntity;
import com.lwt.bookstore_be.entity.ResultBean;
import com.lwt.bookstore_be.entity.UserAuthEntity;
import com.lwt.bookstore_be.entity.UserEntity;
import com.lwt.bookstore_be.exception.MyException;
import com.lwt.bookstore_be.service.UserService;
import com.lwt.bookstore_be.utils.msgutils.MsgCode;
import com.lwt.bookstore_be.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/checkUser")
    public UserAuthEntity checkUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return userService.checkUser(username, password);
    }

    @RequestMapping("/register")
    public ResultBean<Boolean> register(@RequestBody Map<String, String> params) throws MyException {
        String username = params.get(Constant.USERNAME);
        String password = params.get(Constant.PASSWORD);
        String nickname = params.get("nickname");
        String telphone = params.get("tel");
        String address = params.get("address");
//        Integer user_type = Integer.parseInt(params.get("user_type"));
        return ResultBean.success(userService.Register(username,password,nickname,telphone,address));

    }

    @RequestMapping("/getUsers")
    public List<UserAuthEntity> getUsers(@RequestBody Map<String, String> params) {
        return userService.getUsers();
    }

    @RequestMapping("/setUserState")
    public ResultBean<Boolean> setUserState(@RequestBody Map<String, String> params){
        String username = params.get(Constant.USERNAME);
        Integer userState = Integer.parseInt(params.get("userState"));
        return ResultBean.success(userService.setUserState(username,userState));
    }

}
