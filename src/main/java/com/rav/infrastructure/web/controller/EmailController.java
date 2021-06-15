package com.rav.infrastructure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmailController {

    @GetMapping
    public static String emailConfirmed(){
        return "fragments/emailConfirmed";
    }
}
