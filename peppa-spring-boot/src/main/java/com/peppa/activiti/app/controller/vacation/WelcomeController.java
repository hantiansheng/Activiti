package com.peppa.activiti.app.controller.vacation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: hantiansheng
 * @date: 2019/11/4
 * @description:
 */
@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "welcome!";
    }
}
