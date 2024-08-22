package com.makersharks.makersharks_assessment.controller;

import com.makersharks.makersharks_assessment.model.Response;
import com.makersharks.makersharks_assessment.service.ManufacturerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/supplier/")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Supplier", description = "Supplier API")
@SecurityRequirement(name = "bearerAuth")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

//    @PostMapping("/searchSupplier")
//    public List<Manufacturer> getSupplier(@RequestParam(value = "location",required = true) String location) {
//        return manufacturerService.searchSupplier(location);
//    }

    @PostMapping("/searchSupplier")
    public ResponseEntity<Response> getSupplier(
            @RequestParam(value = "location", required = true) String location,
            @RequestParam(value = "nature_of_business" ,required = true) String natureOfBusiness,
            @RequestParam(value = "manufacturing_processes",required = true) String manufacturingProcesses,
            @RequestParam(value = "pageNumber", defaultValue = "0" ,required = false) String pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5" ,required = false) String pageSize
    ) {
        log.info("getSupplier controller called ::: {} ", new Date());
        Response response = new Response();
        if(location.isEmpty() || natureOfBusiness.isEmpty() || manufacturingProcesses.isEmpty()) {
            response.setResultCode(400);
            response.setMessage("Invalid Request. Location, nature of business or manufacturing processes cannot be empty");
        }else{
             response = manufacturerService.searchSupplier(location, natureOfBusiness, manufacturingProcesses, pageNumber, pageSize);
        }

        log.info("getSupplier controller ended ::: {} ", new Date());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getResultCode()));
    }
}
