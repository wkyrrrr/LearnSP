package com.geektime.spring.hello.demo;

import com.jykj.common.api.BookManagerApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abner
 */
@SpringBootApplication
@RestController
public class DemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello, Spring. Terminal";
    }




}
