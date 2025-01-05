package com.weatherapp.weatherapi.dataapi.service;

import com.weatherapp.weatherapi.dataapi.domain.RegionsEntity;
import com.weatherapp.weatherapi.dataapi.repository.RegionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class RegionsService {

    private final RegionsRepository regionsRepository;

    public void generateApiUrls() throws IOException, JSONException {
        log.info("---------------------------------------------------service1");
        for (int i = 1; i < 101; i++) { // 439
            String apiurl = String.format(
                    "https://apis.data.go.kr/1360000/TourStnInfoService1/getTourStnVilageFcst1?ServiceKey=Dxhv%%2FFADXXMPmKxLHMxOkoyMrWL45dwTybbI8frUxCT1eyJKz0WstFSGR5f0XppdMp51F%%2FkluvX3%%2Bm4oTgJHJQ%%3D%%3D&pageNo=1&numOfRows=5&dataType=JSON&CURRENT_DATE=20250103&HOUR=0&COURSE_ID=%d",
                    i
            );

            log.info(apiurl);

            URL url = new URL(apiurl);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            StringBuilder result = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

            // API 응답을 확인하기 위해 로그 출력
            log.info("API response: " + result.toString());

            if (result.toString().startsWith("{")) {
                JSONObject jsonObject = new JSONObject(result.toString());
                // body 키가 있는지 확인
                if (jsonObject.has("response")) {
                    JSONObject response = jsonObject.getJSONObject("response");
                    if (response.has("body")) {
                        JSONObject body = response.getJSONObject("body");
                        JSONObject items = body.getJSONObject("items");
                        JSONArray itemArray = items.getJSONArray("item");

                        for (int j = 0; j < itemArray.length(); j++) {
                            JSONObject item = itemArray.getJSONObject(j);
                            RegionsEntity regions = new RegionsEntity();
                            regions.setCname(item.optString("courseAreaName", "no name"));
                            regions.setSaname(item.optString("spotAreaName", "no name"));
                            regions.setSname(item.optString("spotName", "no name"));

                            // sname이 이미 존재하는지 확인
                            if (regionsRepository.findBySname(regions.getSname()) != null) {
                                log.info("Skipping duplicate sname: " + regions.getSname());
                            } else {
                                log.info("Saving new region: " + regions);
                                regionsRepository.save(regions);
                                log.info("save i ------------------------------------",i);
                            }
                        }
                    } else {
                        log.error("API response does not contain 'body' key");
                    }
                } else {
                    log.error("API response does not contain 'response' key");
                }
            }
        }
    }

}