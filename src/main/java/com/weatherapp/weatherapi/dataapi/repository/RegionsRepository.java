package com.weatherapp.weatherapi.dataapi.repository;

import com.weatherapp.weatherapi.dataapi.domain.RegionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<RegionsEntity, Long> {

    RegionsEntity findBySname(String sname);
}
