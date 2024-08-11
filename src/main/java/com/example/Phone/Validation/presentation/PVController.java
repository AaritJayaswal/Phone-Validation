package com.example.Phone.Validation.presentation;
/*
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
*/
import com.example.Phone.Validation.repository.dto.PVResponse;
import com.example.Phone.Validation.service.PVService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PVController {

    private final PVService pvService;

    public PVController(PVService pvService) {
        this.pvService = pvService;
    }

    @GetMapping("/searchPVResults")
    public PVResponse getResults(@RequestParam(value="q") String query){
        return pvService.getResults(query);
    }

}

//http://localhost:5000/searchPVResults?q=number