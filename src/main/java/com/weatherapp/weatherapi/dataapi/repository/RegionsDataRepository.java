package com.weatherapp.weatherapi.dataapi.repository;

import com.weatherapp.weatherapi.dataapi.domain.RegionsDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsDataRepository extends JpaRepository<RegionsDataEntity, Long> {

    RegionsDataEntity findBySname(String sname);
}
