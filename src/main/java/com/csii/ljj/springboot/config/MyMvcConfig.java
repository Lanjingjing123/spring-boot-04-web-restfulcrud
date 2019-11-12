package com.csii.ljj.springboot.config;

import com.csii.ljj.springboot.component.LoginHandlerInterceptor;
import com.csii.ljj.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展SpringMvc功能:1.将之声明为组件 @Configuration
 *                  2.继承WebMvcConfigurerAdapter，重写里面相应的的方法
 */

//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 增加一个视图转换
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        // 浏览器发送/ljj 请求到success
        registry.addViewController("/ljj").setViewName("success");
    }


    // 所有的WebMvcConfigureAdapter 组件都会一起起作用
    // 将组件注册
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }



            // 拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                // 静态资源 *.css,*.js
                // springBoot已经做好了静态资源映射了，可以不用管理静态资源
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
