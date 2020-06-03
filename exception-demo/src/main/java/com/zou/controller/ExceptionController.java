package com.zou.controller;

import com.sun.org.apache.xml.internal.security.Init;
import com.zou.exception.CustomException;
import com.zou.util.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * @ClassName ExceptionController
 * @Description TODO
 * @Author zouyouxiu
 * @Date 2019/12/25 11:22
 */
@RestController
public class ExceptionController {

    @GetMapping("/test")
    public void exception() {
        System.out.println("controller");
    }
/*
    @GetMapping("/test1")
    public void exception1() {
        int[] arr = {};
        int i = arr[2];
    }*/



    @Autowired(required = false)
    private C c;


    @PostMapping("/test")
    public void test() {
        String s = c.get();
        System.out.println(c);
    }

    @GetMapping("test1")
    public Object methodOne(Model model){
        Map<String, Object> modelMap = model.asMap();
        return modelMap.get("map");
    }


    @GetMapping("test2")
    public String methodTwo(@ModelAttribute("globalAttr") String globalAttr){
        return globalAttr;
    }


    @GetMapping("test3")
    public String methodThree(ModelMap modelMap) {
        return (String) modelMap.get("globalAttr");
    }

}
