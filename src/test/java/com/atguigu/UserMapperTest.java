package com.atguigu;


import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class) //以spring方式进行启动

@SpringBootTest
public class UserMapperTest {

    //解觉红线①：将@Autowire换成@Resources ②：在UserMapper上加上注解@Repository
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAllTest(){
        List<User> users = userMapper.selectAll();
        System.out.println(users);

    }
}
