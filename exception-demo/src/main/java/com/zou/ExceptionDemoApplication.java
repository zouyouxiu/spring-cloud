package com.zou;

import com.zou.controller.A;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ExceptionDemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ExceptionDemoApplication.class, args);
       /* DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();

        defaultListableBeanFactory.removeBeanDefinition("a");

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(A.class);
        beanDefinitionBuilder.addPropertyValue("name","aaa");

        defaultListableBeanFactory.registerBeanDefinition("a",beanDefinitionBuilder.getBeanDefinition());

        A a = applicationContext.getBean(A.class);

        String s = a.get();
        String name = a.getName();
        System.out.println(s);*/
    }

}
