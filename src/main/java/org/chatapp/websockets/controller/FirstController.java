package org.chatapp.websockets.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FirstController {

    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam("name") String name) {
        return "Hello " + name + " ! ";
    }
}
