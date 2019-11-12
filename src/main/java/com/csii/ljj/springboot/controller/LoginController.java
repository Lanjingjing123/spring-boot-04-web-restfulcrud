package com.csii.ljj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    /**
     * 1.现使用@PostMapping 替代 @RequestMapping(value = "/user/login",method = RequestMethod.POST)
     * 2. 使用@RequestParam("username") 获取请求参数username
     * @return
     */
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        Map map, HttpSession session){

        if(!StringUtils.isEmpty(userName) && "123456".equals(password)){
            System.out.println("===========登录成功=============");
            // 登录成功,防止表单重复提交，可以进行重定向
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        } else{
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
