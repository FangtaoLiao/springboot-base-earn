package com.lft.springboot.controller;

import com.lft.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if(user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello world!!";
    }
    //查出一些数据在页面展示
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //classpath:/templates/success/html
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zws","hdh","lft"));
        return "success";
    }
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
