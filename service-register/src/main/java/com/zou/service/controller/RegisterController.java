package com.zou.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @ClassName TestController
 * @Description TODO  Feign远程调用demo
 * @Author zouyouxiu
 * @Date 2019/12/17 10:08
 */
@RestController
public class RegisterController implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        return "port:" + serverPort;
    }
    /**
     * 获取当前服务端口号
     **/
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        serverPort = event.getWebServer().getPort();
    }
}
