package com.lft.springboot.controller;

import com.lft.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(){
//        Map<String,Object> map=new HashMap<>();
//        map.put("code","user.notetext");
//        map.put("message","用户不存在");
//        return map;
//    }

@ExceptionHandler(UserNotExistException.class)
public String handleException(Exception e,HttpServletRequest request){
    Map<String,Object> map=new HashMap<>();
    map.put("code","user.notetext");
    map.put("message",e.getMessage());
    map.put("message1","handleException...");
    //传入我们自己的错误状态码
   // map.put("javax.servlet.error.status_code",418);
    request.setAttribute("ext",map);
    request.setAttribute("javax.servlet.error.status_code",418);
    return "forward:/error";
}
}
