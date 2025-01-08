package com.weatherapp.weatherapi.weathertests;


import com.weatherapp.weatherapi.weather.dto.WeatherDayListDTO;
import com.weatherapp.weatherapi.weather.repository.WeatherRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@Log4j2
@SpringBootTest
public class WeatherTests {

    @Autowired
    private WeatherRepository weatherRepository;

    @Test
    @Transactional
    @Commit
    public void testListWeather() {

        String recorded = "2025-01-05";

        List<WeatherDayListDTO> testList = weatherRepository.WeatherDayList(1L, recorded);

        log.info(testList);

    }
}
