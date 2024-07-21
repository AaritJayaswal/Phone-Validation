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
   /* @ApiOperation(value = "Searches for articles matching the search term",
            notes = "Response may include multiple Result values.",
            response = Result.class,
            responseContainer="List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Result(s) found"),
            @ApiResponse(code = 404, message = "Result(s) not found")
    })*/
    //milestone 5

    public PVResponse getResults(@RequestParam(value="q") String query){
        return pvService.getResults(query);
    }

}