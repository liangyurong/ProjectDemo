package com.lyr.demo.other;

import com.lyr.demo.annotation.CustomLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestOther {
    @CustomLog("使用自定义注解")
    @ResponseBody
    @GetMapping("/getB")
    public String getB(){
        return "BBBBBBBBBBB";
    }
}
