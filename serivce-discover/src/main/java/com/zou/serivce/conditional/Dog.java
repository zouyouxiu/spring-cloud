package com.zou.serivce.conditional;

import com.zou.serivce.conditional.Animal;
import org.springframework.stereotype.Service;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/22 0:14
 */
@Service
public class Dog implements Animal {
    @Override
    public String eat() {
        return "肉";
    }
}
