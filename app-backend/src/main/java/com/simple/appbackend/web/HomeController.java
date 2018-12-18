package com.simple.appbackend.web;

import com.simple.appbackend.exception.SupportInfoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/{id}")
    public String home(@PathVariable int id) {
        if(id  == 1)
        {
            throw new SupportInfoException("help");
        }
        if(id  == 2)
        {
            throw new NullPointerException("help");
        }
        return "boe";
    }
}
