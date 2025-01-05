package com.weatherapp.weatherapi.regions.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tbl_regions")
public class RegionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    private String cname; // 제주특별자치도

    private String saname; // 제주

    private String sname; // 제주현대미술관


}
