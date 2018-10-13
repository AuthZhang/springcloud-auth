package com.example.demo.config;

import com.example.demo.filter.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.catalina.valves.RemoteIpValve;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author zhangyu
 * @Date 2018/9/28
 */
@Configuration
public class WebConfiguration {

    /***
     * 远程ip过滤
     * @Author zhangyu
     * @Description
     * @Date 2018/9/28
     * @Param
     * @return
     **/
    @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

}
