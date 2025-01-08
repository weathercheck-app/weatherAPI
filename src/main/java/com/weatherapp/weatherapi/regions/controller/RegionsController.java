package com.weatherapp.weatherapi.regions.controller;


import com.weatherapp.weatherapi.regions.dto.RegionsFirstListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsSecondListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsThirdListDTO;
import com.weatherapp.weatherapi.regions.service.RegionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/regions")
@Log4j2
@RequiredArgsConstructor
public class RegionsController {

    private final RegionsService regionsService;

    @GetMapping("/first")
    public ResponseEntity<List<RegionsFirstListDTO>> RegionsFirstSearch() {

        log.info("Regions first search");

        return ResponseEntity.ok(regionsService.RegionsFirstSearch());
    }

    @GetMapping("/second")
    public ResponseEntity<List<RegionsSecondListDTO>> RegionsSecondSearch(@RequestParam("cname") String cname) {

        log.info("Regions second search");

        return ResponseEntity.ok(regionsService.RegionsSecondSearch(cname));
    }

    @GetMapping("/third")
    public ResponseEntity<List<RegionsThirdListDTO>> RegionsThirdSearch(@RequestParam("saname") String saname) {
        log.info("Regions third search");

        return ResponseEntity.ok(regionsService.RegionsThirdSearch(saname));
    }
}
