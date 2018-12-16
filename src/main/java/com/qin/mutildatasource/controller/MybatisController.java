package com.qin.mutildatasource.controller;

import com.qin.mutildatasource.entity.User;
import com.qin.mutildatasource.test1.MybatisService1;
import com.qin.mutildatasource.test2.MybatisService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注释：
 * 作者：秦盟
 * 时间：2018-12-16 21:52
 */
@RestController
public class MybatisController {
    @Autowired
    MybatisService1 service1;
    @Autowired
    MybatisService2 service2;

    @Transactional(value = "test1TransactionManager")
    @RequestMapping("add1")
    public String addUser1() {
        User user = new User();
        service1.insertUser(user.getAge(), user.getName());
//        int i = 1 / 0;
        return "zbq";
    }

    @Transactional(transactionManager = "test2TransactionManager")
    @RequestMapping("add2")
    public String addUser2() {
        User user = new User();
        service2.insertUser(user.getAge(), user.getName());
//        int i = 1 / 0;
        return "zbq";
    }

    //方法里面操作两个数据源，但是只指定了一个事务，另一个在发生异常时还可以插入数据
    @Transactional(transactionManager = "test2TransactionManager")
    @RequestMapping("add12")
    public String addUser12() {
        User user = new User();
        service1.insertUser(user.getAge(), user.getName());
        service2.insertUser(user.getAge(), user.getName());
        int i = 1 / 0;
        return "zbq";
    }
}
