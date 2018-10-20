package com.lft.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
   @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
       if(!StringUtils.isEmpty(username)&&"12".equals(password)){
           //登录成功
           session.setAttribute("loginUser",username);
           return "redirect:/main.html";
       }else{
           map.put("msg","用户名密码错误");
           return "login";
       }
    }
    @GetMapping("/user/out")
    public String loginOut(Map<String,Object> map,HttpSession session){
       session.removeAttribute("loginUser");
        map.put("msg","已经登出！");
       return "login";
    }
}
