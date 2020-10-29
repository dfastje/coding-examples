package me.dfastje.swaggerproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping(value = "/example")
    public String example(){
        return "HelloWorld";
    }
}
