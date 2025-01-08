package com.weatherapp.weatherapi.weather.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class WeatherDayListDTO {

    private LocalDateTime recorded_at;

    private int temper;

    private int winds;

    private int rhm;

    private int pop;
}
