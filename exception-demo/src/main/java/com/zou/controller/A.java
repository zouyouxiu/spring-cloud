package com.zou.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @ClassName A
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/2 16:41
 */
/*
 * @Description TODO 实现 InstantiationAwareBeanPostProcessor 接口，重写 postProcessBeforeInstantiation 方法  方法里判断你想要覆盖的那个bean的名字，然后return 你的bean实例
 * @Author zouyouxiu
 * @Date 2020/1/2 16:51
 * @param null
 * @return
 **/
@Component
@Primary
public class A implements C {
    private String name;

    @Override
    public String get() {
        return "aa";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

/*@Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        C a = (C) beanFactory.getBean("a");
        C b = (C) beanFactory.getBean("b");
        String s = a.get();
        String s1 = b.get();
        System.out.println(s);
        System.out.println(s1);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("b")){
            System.out.println(beanName);
            return new A();
        }
        return null;
    }*/

}
