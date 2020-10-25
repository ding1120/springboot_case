package com.atguigu.service.impl;

import com.atguigu.dao.UserMapper;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //注入redis模板
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * propagation
     * 传播行为:7种
     * 事务隔离级别:4种
     * 1 未提交读  READ_UNCOMMITTED
     * 2 读已提交 READ_COMMITTED   oracle默认隔离级别
     * 4 可重复读  REPEATABLE_READ  MySQL默认隔离级别
     * 问题： 数据丢失，脏读，不可重复读，幻读
     */
    @Transactional(propagation =Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            rollbackFor = Exception.class,
            noRollbackFor = FileNotFoundException.class)
    @Override
    public List<User> findAll() {

        //int i = 1/0; //运行时异常，Spring AOP 声明式事务，默认对于运行时异常进行回滚。
        //FileInputStream xxx = new FileInputStream("xxx");  //编译期异常；默认不回滚的
        /**
         *  List<User> users = userMapper.selectAll();
         *         System.out.println("users="+users);
         *         return users;
         *  由于每次查询数据都是要从数据库进行查询，所以将代码改写，引入redis,将查询回来的数据存储到redis中
         */

        //绑定一个数据,将key值取出
        List<User> users = (List<User>) redisTemplate.boundValueOps("userKey").get();
        if(users==null){//缓存中没有的数据
            users = userMapper.selectAll();//从数据库中进行查询
            System.out.println("users="+users);
            redisTemplate.boundValueOps("userKey").set(users); //存入缓存中
        }else{//缓存中有数据

            System.out.println("从缓存中users="+users);
        }
        return users;
    }


}