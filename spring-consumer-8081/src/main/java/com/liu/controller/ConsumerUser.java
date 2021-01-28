package com.liu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumerUser {
    final  String URL ="http://SPRINGCLOUD-PROVIDER-USER";
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/getuser")
    public Object getuser(){
        System.out.println(URL+"/getuser");
        return  restTemplate.getForObject(URL+"/getuser", String.class);
    }
    @RequestMapping("/index")
    public String indx(){
        return "index";
    }

}
