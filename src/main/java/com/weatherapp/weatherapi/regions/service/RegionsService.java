package com.weatherapp.weatherapi.regions.service;


import com.weatherapp.weatherapi.regions.dto.RegionsListDTO;
import com.weatherapp.weatherapi.regions.repository.RegionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class RegionsService {

    private final RegionsRepository regionsRepository;

    public List<RegionsListDTO> RegionsSecondSearch(String cname) {

        log.info("RegionsSecondSearchService");

        return regionsRepository.RegionsSearch(cname);

    }
}



