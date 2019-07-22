package com.books.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/vi/test")
public class TestController {

    @GetMapping("/hello")
    public Map test(){
        return Collections.singletonMap("test","123");
    }
}
