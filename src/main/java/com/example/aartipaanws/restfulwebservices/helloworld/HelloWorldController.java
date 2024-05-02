package com.example.aartipaanws.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class HelloWorldController {

    @GetMapping(path="hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
    }

    @GetMapping(path="hello-world/{name}")
    public HelloWorldBean helloWorldBean1(@PathVariable String name){
        return new HelloWorldBean("Hello World" + name);
    }
}
