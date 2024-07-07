package com.example.Phone.Validation.service;

import org.springframework.stereotype.Service;

@Service
public class PVService {

    public String getResults(String query) {
        return "Validting number: " + query;
    }
}
