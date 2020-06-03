package com.zou.serivce.conditional;

import org.springframework.stereotype.Service;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/22 0:11
 */
@Service
public class Cat implements Animal {
    @Override
    public String eat() {
        return "老鼠";
    }
}
