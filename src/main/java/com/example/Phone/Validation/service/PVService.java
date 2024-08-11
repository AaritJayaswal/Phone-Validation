package com.example.Phone.Validation.service;

import com.example.Phone.Validation.repository.PVRepository;
import com.example.Phone.Validation.repository.dto.PVResponse;
import org.springframework.stereotype.Service;

@Service
public class PVService {

    private final PVRepository pvRepository;
    public PVService(PVRepository pvRepository) {
        this.pvRepository = pvRepository;
    }
    public PVResponse getResults(String query){
        return pvRepository.validateNumber(query);
    }
}