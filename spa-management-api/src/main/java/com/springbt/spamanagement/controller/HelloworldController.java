package com.springbt.spamanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @GetMapping("/hello")
     public String hello(){
         return "veera ";
     }
}
