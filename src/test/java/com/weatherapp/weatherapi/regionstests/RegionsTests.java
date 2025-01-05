package com.weatherapp.weatherapi.regionstests;


import com.weatherapp.weatherapi.regions.dto.RegionsSecondListDTO;
import com.weatherapp.weatherapi.regions.repository.RegionsRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import java.util.List;

@Log4j2
@SpringBootTest
public class RegionsTests {

    @Autowired
    private RegionsRepository regionsRepository;

    @Test
    @Transactional
    @Commit
    public void testListRegions() {

        String cname = "경상남도";

        List<RegionsSecondListDTO> result = regionsRepository.RegionsSecondSearch(cname);

        log.info(result);

    }

}
