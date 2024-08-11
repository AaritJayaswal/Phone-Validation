package com.example.Phone.Validation.service;

import com.example.Phone.Validation.repository.PVRepository;
import com.example.Phone.Validation.repository.dto.PVResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PVServiceTest {

    private PVService pvService;

    @Mock
    private PVRepository pvRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pvService = new PVService(pvRepository);
    }

    @Test
    void whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        PVResponse response = new PVResponse();
        response.setPhone("8582619192");
        response.setValid(true);
        //response.setAuthors(Collections.singletonList("AUTHORS"));
        List<PVResponse> expectedResults = Collections.singletonList(response);

        when(pvRepository.validateNumber(query))
                .thenReturn((PVResponse) expectedResults);

        //when
        List<PVResponse> actualResults = (List<PVResponse>) pvService.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }

}