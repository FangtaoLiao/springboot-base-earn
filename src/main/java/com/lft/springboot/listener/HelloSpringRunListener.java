package com.lft.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringRunListener implements SpringApplicationRunListener {
    public HelloSpringRunListener(SpringApplication springApplication,String... args) {
    }

    @Override
    public void starting() {
        System.out.println("HelloSpringRunListener...starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        String str=(String)environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener...environmentPrepared..."+str);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextPrepared....");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("SpringApplicationRunListener...contextLoaded...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("ConfigurableApplicationContext...running...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("ConfigurableApplicationContext...failed...");
    }
}
