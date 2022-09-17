package com.kakaomaptest.kakaomap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressController {

    @GetMapping("/index")
    public String address(){
        return "address";
    }
}
