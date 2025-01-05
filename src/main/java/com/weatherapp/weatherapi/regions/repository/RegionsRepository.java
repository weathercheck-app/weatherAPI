package com.weatherapp.weatherapi.regions.repository;


import com.weatherapp.weatherapi.regions.domain.RegionsEntity;
import com.weatherapp.weatherapi.regions.repository.search.RegionsSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionsRepository extends JpaRepository<RegionsEntity, Long>, RegionsSearch {
}
