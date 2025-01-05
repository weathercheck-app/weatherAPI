package com.weatherapp.weatherapi.regions.repository.search;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.weatherapp.weatherapi.regions.domain.QRegionsEntity;
import com.weatherapp.weatherapi.regions.domain.RegionsEntity;
import com.weatherapp.weatherapi.regions.dto.RegionsListDTO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RegionsSearchImpl extends QuerydslRepositorySupport implements RegionsSearch {

    public RegionsSearchImpl() {
        super(RegionsEntity.class);
    }

    @Override
    public List<RegionsListDTO> RegionsSearch(String cname) {

        QRegionsEntity Regions = QRegionsEntity.regionsEntity;
        JPQLQuery<RegionsEntity> query = from(Regions);

        query.where(Regions.cname.eq(cname));

        JPQLQuery<RegionsListDTO> dtojpqlQuery = query.select(
                Projections.bean(RegionsListDTO.class,
                        Regions.rid,
                        Regions.saname,
                        Regions.sname
                )
        );

        List<RegionsListDTO> dtoList = dtojpqlQuery.fetch();

        return dtoList;


    }
}








