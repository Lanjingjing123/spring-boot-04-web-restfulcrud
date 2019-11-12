package com.csii.ljj.springboot.component;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以再连接上携带
 */
public class MyLocalResolver  implements LocaleResolver {

    /**
     * 解析区域信息
     * 默认的是使用 AcceptHeaderLocaleResolver.resolveLocale中的区域信息解析器进行配置，
     *          入口在WebMvcAutoConfigurationAdapter
     * @param request
     * @return
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] split = l.split("_");

            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
