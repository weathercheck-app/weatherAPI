package com.weatherapp.weatherapi.dataapi.controller;

import com.weatherapp.weatherapi.dataapi.service.RegionsDataService;
import com.weatherapp.weatherapi.dataapi.service.WeatherDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/data/weather")
@Log4j2
public class WeatherDataController {

    private final RegionsDataService regionsDataService;
    private final WeatherDataService weatherDataService;

    @GetMapping("/regions")
    public void save() throws IOException, JSONException {
        log.info("---------------------------------------------------controller1");
        regionsDataService.generateApiUrls();
        log.info("---------------------------------------------------controller2");
    }

    @GetMapping("/temper")
    public void saveTemper() throws IOException, JSONException {
        log.info("---------------------------------------------------controller1");
        int c_date = 20250104;
        weatherDataService.generateApiUrls(c_date);
        log.info("---------------------------------------------------controller2");

    }



}
