package com.example.Phone.Validation.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PVController {

    @GetMapping("/searchPVResults")
    //milestone 4
    //@ApiOperation(value = "Checks if phone number is valid", response = String.class)

    public String getResults(@RequestParam(value="q") String query){
    return "Checking number: " + query;
}
}



