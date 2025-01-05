package com.weatherapp.weatherapi.regions.repository.search;

import com.weatherapp.weatherapi.regions.dto.RegionsListDTO;

import java.util.List;

public interface RegionsSearch {

    List<RegionsListDTO> RegionsSearch(String cname);
}
