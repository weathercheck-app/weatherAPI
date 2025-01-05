package com.weatherapp.weatherapi.regions.repository.search;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.weatherapp.weatherapi.regions.domain.QRegionsEntity;
import com.weatherapp.weatherapi.regions.domain.RegionsEntity;
import com.weatherapp.weatherapi.regions.dto.RegionsFirstListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsSecondListDTO;
import com.weatherapp.weatherapi.regions.dto.RegionsThirdListDTO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class RegionsSearchImpl extends QuerydslRepositorySupport implements RegionsSearch {

    public RegionsSearchImpl() {
        super(RegionsEntity.class);
    }

    @Override
    public List<RegionsFirstListDTO> RegionsFisrtSearch() { // 경상남도 추출


        QRegionsEntity Regions = QRegionsEntity.regionsEntity;
        JPQLQuery<RegionsEntity> query = from(Regions);

        JPQLQuery<RegionsFirstListDTO> dtojpqlQuery = query.select(
                Projections.bean(RegionsFirstListDTO.class,
                        Regions.cname
                )
        ).groupBy(Regions.cname);

        List<RegionsFirstListDTO> dtoList = dtojpqlQuery.fetch();

        return dtoList;
    }

    @Override
    public List<RegionsSecondListDTO> RegionsSecondSearch(String cname) { // 함양 추출

        QRegionsEntity Regions = QRegionsEntity.regionsEntity;
        JPQLQuery<RegionsEntity> query = from(Regions);

        query.where(Regions.cname.eq(cname));

        JPQLQuery<RegionsSecondListDTO> dtojpqlQuery = query.select(
                Projections.bean(RegionsSecondListDTO.class,
                        Regions.rid,
                        Regions.saname
                )
        ).groupBy(Regions.saname);

        List<RegionsSecondListDTO> dtoList = dtojpqlQuery.fetch();

        return dtoList;


    }

    @Override
    public List<RegionsThirdListDTO> RegionsThirdSearch(String saname) {

        QRegionsEntity Regions = QRegionsEntity.regionsEntity;
        JPQLQuery<RegionsEntity> query = from(Regions);

        query.where(Regions.saname.eq(saname));

        JPQLQuery<RegionsThirdListDTO> dtojpqlQuery = query.select(
                Projections.bean(RegionsThirdListDTO.class,
                        Regions.rid,
                        Regions.sname
                )
        ).groupBy(Regions.sname);

        List<RegionsThirdListDTO> dtoList = dtojpqlQuery.fetch();

        return dtoList;
    }
}








