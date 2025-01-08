package com.weatherapp.weatherapi.weather.repository;

import com.weatherapp.weatherapi.weather.domain.WeatherEntity;
import com.weatherapp.weatherapi.weather.repository.search.WeatherSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long>, WeatherSearch {
}
