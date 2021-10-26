package com.study.tacos.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author abner
 */

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
