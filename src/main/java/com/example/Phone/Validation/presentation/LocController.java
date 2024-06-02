package com.example.Phone.Validation.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocController {

    @GetMapping("/searchLocResults")
    
    public String getResults(){
        return "Hello, world!";
    }

}
