package com.atguigu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan; //tk 通用的组件包

@EnableTransactionManagement //开启声明式事务
@MapperScan("com.atguigu.dao")//设置扫描dao层包，否则无法创建dao的对象
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
