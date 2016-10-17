package com.gdpu.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 郭旭辉 on 2016/9/21.
 * 页面公用跳转类
 */
@Controller
@RequestMapping(value = "/page")
public class PageController {

    @RequestMapping(value = "{pageName}", method = RequestMethod.GET)
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }
}
