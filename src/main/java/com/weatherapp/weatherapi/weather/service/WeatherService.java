package com.weatherapp.weatherapi.weather.service;

import com.weatherapp.weatherapi.weather.dto.WeatherDayListDTO;
import com.weatherapp.weatherapi.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class WeatherService {

    final private WeatherRepository weatherRepository;

    public List<WeatherDayListDTO> WeatherDayList(Long rid, String recorded) {

        log.info("Getting weather day list");

        return weatherRepository.WeatherDayList(rid, recorded);

    }
}
