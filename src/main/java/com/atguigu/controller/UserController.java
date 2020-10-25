package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 最后返回结果是json形式,需要改成页面形式返回,加入静态页面
 */
@RestController
public class UserController {

    @Autowired
   private UserService userService;

    @RequestMapping("/user/findAll")
    //统一返回结果
    public Result findAll(){
        List<User> users = userService.findAll();
        return Result.ok(true,"成功",users);

    }


}
