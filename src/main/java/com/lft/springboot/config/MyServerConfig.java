package com.lft.springboot.config;

import com.lft.springboot.filter.MyFilter;
import com.lft.springboot.listener.MyListener;
import com.lft.springboot.servlet.MyServlet;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


@Configuration
public class MyServerConfig {
    //配置嵌入式容器相关设置
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.setPort(8080);
        return tomcat;
    }

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new MyServlet(),"/myServlet");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myFilter"));
        return filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean=new ServletListenerRegistrationBean<MyListener>();
        servletListenerRegistrationBean.setListener(new MyListener());
        return servletListenerRegistrationBean;

    }
 }

