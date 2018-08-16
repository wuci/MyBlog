package com.myblog.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * /**
 *
 * @author: wuci
 * @date: 2018/7/19
 * @copyright:zjkj
 * @since : v 1.0
 */
@RestController
public class indexController {
    @RequestMapping("/index")
    public String index() {
        return "welcome!";
    }
}
