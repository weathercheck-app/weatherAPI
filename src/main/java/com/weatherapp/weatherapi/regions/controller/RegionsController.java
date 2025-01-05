package com.weatherapp.weatherapi.regions.controller;


import com.weatherapp.weatherapi.regions.dto.RegionsFirstListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsSecondListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsThirdListDTO;
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

    @GetMapping("/first")
    public List<RegionsFirstListDTO> RegionsFirstSearch() {

        log.info("Regions first search");

        return regionsService.RegionsFirstSearch();
    }

    @GetMapping("/second")
    public List<RegionsSecondListDTO> RegionsSecondSearch(@RequestParam("cname") String cname) {

        log.info("Regions second search");

        return regionsService.RegionsSecondSearch(cname);
    }

    @GetMapping("/third")
    public List<RegionsThirdListDTO> RegionsThirdSearch(@RequestParam("saname") String saname) {
        log.info("Regions third search");

        return regionsService.RegionsThirdSearch(saname);
    }
}
