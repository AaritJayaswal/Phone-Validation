package com.example.Phone.Validation.repository;

import com.example.Phone.Validation.repository.dto.PVResponse;
import com.fasterxml.jackson.annotation.JsonAlias;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LocRepositoryTest {

    private PVRepository pvRepository;

    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<PVRepository> LocResponseMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        pvRepository = new PVRepository(webClientMock);
    }

    @Test
    void whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        PVResponse response = new PVResponse();

        response.setPhone("8582619192");
        response.setValid(true);
        //response.setLink("LINK");
        List<PVResponse> expectedResults = Collections.singletonList(response);
       // response.setResults(expectedResults);

        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(PVResponse.class))
                .thenReturn(PVResponseMonoMock);
        when(LocResponseMonoMock.block())
                .thenReturn(response);

        //when
        List<PVResponse> actualLocResults = pvRepository.validateNumber(query);

        //then
        assertEquals(expectedResults, actualLocResults);
    }

}