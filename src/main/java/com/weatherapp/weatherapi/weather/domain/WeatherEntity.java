package com.weatherapp.weatherapi.weather.domain;

import com.weatherapp.weatherapi.dataapi.domain.RegionsDataEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tbl_weather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wid;

    private LocalDateTime recorded_at; // 날짜

    private int temper; // 온도

    private int winds; // 바람

    private int rhm; // 습도

    private int pop; // 강수확률

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="rid")
    private RegionsDataEntity regions;
}
