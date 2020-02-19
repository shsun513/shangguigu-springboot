package com.minidwep.springboot04.controller;

import com.minidwep.springboot04.exception.UserLoginException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("hello")
    @ResponseBody
    public  String Hello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserLoginException();
        }
        return "hello";
    }

    @RequestMapping("success")
    public  String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zs","ls","ww"));
        return "success";
    }
//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }
}
