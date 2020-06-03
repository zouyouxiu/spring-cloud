package com.zou.serivce.conditional;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.StandardMethodMetadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName BoyCondition
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/18 18:57
 */
public class BoyCondition implements Condition {
    //校验是否为boy类型的bean
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        StandardMethodMetadata standardMethodMetadata = null;
        //向下转型，为了使用子类的方法获取方法名
        if (metadata instanceof StandardMethodMetadata) {
            standardMethodMetadata = (StandardMethodMetadata) metadata;
        }
        //如果方法名不匹配，就去看@Bean注解是否定义了beanName
        if (!"boy".equals(standardMethodMetadata.getMethodName())) {
            MergedAnnotations annotations = metadata.getAnnotations();
            MergedAnnotation<Bean> beanMergedAnnotation = annotations.get(Bean.class);
            Map<String, Object> map = beanMergedAnnotation.asMap();
            String[] name = (String[]) map.get("name");
            //使用stream流判断是否符合条件，好处：延迟加载，当数组为空的时候，不会执行方法体中的内容，直接返回false
            if (!Stream.of(name).anyMatch(s -> "boy".equals(s))) {
                return false;
            }
        }
        return true;
    }
}
