package com.weatherapp.weatherapi.regions.repository.search;

import com.weatherapp.weatherapi.regions.dto.RegionsFirstListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsSecondListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsThirdListDTO;

import java.util.List;

public interface RegionsSearch {


    List<RegionsFirstListDTO> RegionsFisrtSearch();

    List<RegionsSecondListDTO> RegionsSecondSearch(String cname);

    List<RegionsThirdListDTO> RegionsThirdSearch(String saname);
}
