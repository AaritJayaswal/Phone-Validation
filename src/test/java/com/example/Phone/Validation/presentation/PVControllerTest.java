package com.example.Phone.Validation.presentation;

import com.example.Phone.Validation.repository.dto.PVResponse;
import com.example.Phone.Validation.service.PVService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PVControllerTest {

    private PVController pvController;

    @Mock
    private PVService pvService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pvController = new PVController(pvService);
    }

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        PVResponse response = new PVResponse();
        response.setPhone("8582619192");
        response.setValid(true);
        //response.setAuthors(Collections.singletonList("AUTHORS"));
        List<PVResponse> expectedResults = Collections.singletonList(response);

        when(pvService.getResults(query))
                .thenReturn((PVResponse) expectedResults);

        //when
        List<PVResponse> actualResults = (List<PVResponse>) pvController.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() {
        //given
        String query = "Java";

        //when
        //then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> pvController.getResults(query));
        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND \"Result(s) not found.\"");
    }

}