package ru.geekbrains.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Olesia!";
    }

    @GetMapping("/hello_user")
    @ResponseBody
    public String sayHelloUser(@RequestParam(defaultValue = "Unknown") String name,
                               @RequestParam(defaultValue = "Unknown") String surname) {
        return String.format("Hello, %s %s", name, surname);
    }

    @GetMapping("/docs/{doc_id}/info")
    @ResponseBody
    public String showDocInfo(@PathVariable(name = "doc_id") Long id) {
        return "Document #" + id;
    }

}
