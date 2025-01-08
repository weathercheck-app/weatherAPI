package com.weatherapp.weatherapi.weather.repository.search;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.weatherapp.weatherapi.weather.domain.QWeatherEntity;
import com.weatherapp.weatherapi.weather.domain.WeatherEntity;
import com.weatherapp.weatherapi.weather.dto.WeatherDayListDTO;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.sql.Timestamp;
import java.util.List;

public class WeatherSearchImpl extends QuerydslRepositorySupport implements WeatherSearch {

    public WeatherSearchImpl() {
        super(WeatherEntity.class);
    }


    @Override
    public List<WeatherDayListDTO> WeatherDayList(Long rid, String recorded) {

        QWeatherEntity Weather = QWeatherEntity.weatherEntity;
        JPQLQuery<WeatherEntity> query = from(Weather);

        query.where(Weather.regions.rid.eq(rid)
                .and(Weather.recorded_at.stringValue().like(recorded + "%")));

        JPQLQuery<WeatherDayListDTO> dtojpqlQuery = query.select(
                Projections.bean(WeatherDayListDTO.class,
                        Weather.recorded_at,
                        Weather.temper,
                        Weather.winds,
                        Weather.rhm,
                        Weather.pop
                )
        );

        List<WeatherDayListDTO> dtoList = dtojpqlQuery.fetch();


        return dtoList;
    }


}
