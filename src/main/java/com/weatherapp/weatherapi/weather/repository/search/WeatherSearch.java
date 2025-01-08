package com.weatherapp.weatherapi.weather.repository.search;

import com.weatherapp.weatherapi.weather.dto.WeatherDayListDTO;

import java.util.List;

public interface WeatherSearch {

    List<WeatherDayListDTO> WeatherDayList(Long rid, String recorded);
}
