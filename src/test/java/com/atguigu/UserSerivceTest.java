package com.atguigu;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserSerivceTest {

    @Autowired
    private UserService userService;
    @Test
    public void findAll(){
        List<User> all = userService.findAll();
        System.out.println(all);
    }
}
