package com.csii.ljj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloControler {

    /**
     * restful 风格返回字符串
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello world";
    }


    /**
     * 这里使用Thymeleaf 模板引擎不能使用 @responseBody注解,@responseBody只返回数据
     *
     * @param map
     * @return
     */
    @RequestMapping("success")
    public String success(Map<String, Object> map) {
        // classpath:/templates/success.html
        map.put("hello", "你好！");
        return "success";
    }


    /**
     * 默认跳转到主页,模板引擎的路径是/templates目录下进行匹配不会进入public目录
     */
//    @RequestMapping({"/", "/login"})
//    public String index() {
//        return "login";
//    }


}
