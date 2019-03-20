package com.gulteking.wsdemo.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/csrf")
public class CsrfController {


    @GetMapping
    public CsrfToken getCsrfToken(CsrfToken csrfToken){
        return csrfToken;
    }
}
