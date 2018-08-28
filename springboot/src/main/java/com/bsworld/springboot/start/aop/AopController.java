package com.bsworld.springboot.start.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
*author: xieziyang
*date: 2018/7/10
*time: 15:58
*description:
*/
@RestController
public class AopController {
    @Autowired
    AopService aopService;

    @PostMapping("/aop")
    public void run() {
        List<User> users = aopService.selectAllUser();
        System.out.println(users);
        List<User> users1 = aopService.selectAllUser();
        System.out.println(users1);
       /* User user0 = aopService.selectUser("name0");
        System.out.println("user0: " + user0);
        User user1 = aopService.selectUser("name0");
        System.out.println("user1: " + user1);
        System.out.println("------------------------------------------");
        aopService.update("name0", "testPass");
        User user = aopService.selectUser("name0");
        System.out.println("after update" + user);*/
/*
        List<User> users = aopService.selectAllUser();
        System.out.println("users0:" + users);
        List<User> users1 = aopService.selectAllUser();
        System.out.println("user1:" + users1);

        List<User> users2 = aopService.updateUser("name0", "testPass");
        System.out.println("updateUser" + users2);

        List<User> users3 = aopService.selectAllUser();
        System.out.println("user3:" + users3);*/
    }
}
