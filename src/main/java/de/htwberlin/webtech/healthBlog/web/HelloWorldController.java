package de.htwberlin.webtech.healthBlog.web;

//import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;

//Controller Klasse via https://spring.io/guides/gs/spring-boot/#initial
@RestController
public class HelloWorldController {

    //@GetMapping(path = "/")
    @GetMapping("/")
    public String index(){
        return "Hello World!";
    }

    /*public ModelAndView showHelloWorldpage(){
        return new ModelAndView("helloworld");
    }*/
}
