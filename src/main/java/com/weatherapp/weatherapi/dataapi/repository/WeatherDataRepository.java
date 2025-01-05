package com.weatherapp.weatherapi.dataapi.repository;

import com.weatherapp.weatherapi.dataapi.domain.WeatherDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherDataEntity, Long> {


}
