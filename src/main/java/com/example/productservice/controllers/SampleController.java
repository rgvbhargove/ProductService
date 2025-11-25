package com.example.productservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/Hello/{name}/{times}")
    public String sayHello(@PathVariable ("name") String name,
                           @PathVariable("times") int x){

        String s = "";
        for(int i=0; i<x; i++){
            s+="Hello "+name + "</br>";
        }

        return s;
    }
    @GetMapping("/Hi")
    public String sayHi()
    {
        return "Hi there!";
    }

}
