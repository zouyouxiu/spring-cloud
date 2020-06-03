package com.zou.eureka;

/**
 * @ClassName RoleDemo
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/10 9:47
 */
public class RoleDemo {
    public static void main(String[] args) {
        String op = RoleEnum.valueOf("ROLE_ENUM_A").op();
        String op1 = RoleEnum.ROLE_ENUM_A.op();
        System.out.println(op);
    }
}
