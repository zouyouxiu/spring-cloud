package com.zou.controller;

import org.springframework.stereotype.Component;

/**
 * @ClassName B
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2020/1/2 16:42
 */

public class B implements C {
    @Override
    public String get() {
        return "bb";
    }
}
