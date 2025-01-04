package com.weatherapp.weatherapi.dataapi.controller;

import com.weatherapp.weatherapi.dataapi.dto.RegionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.IIOException;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/weather")
@Log4j2
public class WeatherController {

    private final RegionsService regionsService;

    @GetMapping("/regions")
    public void save() throws IOException, JSONException {
        log.info("---------------------------------------------------controller1");
        regionsService.generateApiUrls();
        log.info("---------------------------------------------------controller2");
    }



}
