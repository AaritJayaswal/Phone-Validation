package com.example.Phone.Validation.service;

import com.example.Phone.Validation.repository.PVRepository;
import org.springframework.stereotype.Service;

@Service
public class PVService {

    private final PVRepository pvRepository;
    public PVService(PVRepository pvRepository) {
        this.pvRepository = pvRepository;
    }
    public String getResults(String query){
        return pvRepository.validateNumber(query);
    }
}
