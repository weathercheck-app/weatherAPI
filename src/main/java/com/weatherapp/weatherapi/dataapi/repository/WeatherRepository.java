package com.weatherapp.weatherapi.dataapi.repository;

import com.weatherapp.weatherapi.dataapi.domain.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {


}
