package com.weatherapp.weatherapi.regions.controller;


import com.weatherapp.weatherapi.regions.dto.RegionsListDTO;
import com.weatherapp.weatherapi.regions.service.RegionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Regions")
@Log4j2
@RequiredArgsConstructor
public class RegionsController {

    private final RegionsService regionsService;

    @GetMapping("/second")
    public List<RegionsListDTO> RegionsSecondSearch(@RequestParam("cname") String cname) {

        return regionsService.RegionsSecondSearch(cname);
    }
}
