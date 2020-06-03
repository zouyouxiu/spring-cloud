package com.zou.serivce.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName UserCondition
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/18 23:54
 */
public class UserCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
    }
}
