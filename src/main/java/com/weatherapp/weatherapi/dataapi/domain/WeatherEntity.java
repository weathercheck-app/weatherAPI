package com.weatherapp.weatherapi.dataapi.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tbl_weather")
@ToString(exclude = {"regions"})
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wid;

    private Timestamp recorded_at; // 날짜

    private int temper; // 온도

    private int winds; // 바람

    private int rhm; // 습도

    private int pop; // 강수확률

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="rid")
    private RegionsEntity regions;




}
