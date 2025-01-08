package com.weatherapp.weatherapi.weather.controller;


import com.weatherapp.weatherapi.weather.dto.WeatherDayListDTO;
import com.weatherapp.weatherapi.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/day")
    public ResponseEntity<List<WeatherDayListDTO>> WeatherDayList(@RequestParam("rid") Long rid, @RequestParam("recorded") String recorded){

        log.info("Weather Day List");

        return ResponseEntity.ok(weatherService.WeatherDayList(rid, recorded));
    }
}
