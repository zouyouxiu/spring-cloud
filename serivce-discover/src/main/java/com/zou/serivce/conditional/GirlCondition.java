package com.zou.serivce.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName GirlCondition
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/18 18:58
 */
public class GirlCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
