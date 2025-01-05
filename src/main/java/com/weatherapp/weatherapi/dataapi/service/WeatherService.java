package com.weatherapp.weatherapi.dataapi.service;

import com.weatherapp.weatherapi.dataapi.domain.RegionsEntity;
import com.weatherapp.weatherapi.dataapi.domain.WeatherEntity;
import com.weatherapp.weatherapi.dataapi.repository.RegionsRepository;
import com.weatherapp.weatherapi.dataapi.repository.WeatherRepository;
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
import java.sql.Timestamp;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final RegionsRepository regionsRepository;

    public void generateApiUrls(int c_date) throws IOException, JSONException {
        log.info("---------------------------------------------------service1");
        for (int i = 1; i < 101; i++) { // 439 (rid total 292)
            for (int q = 0; q < 25; q += 3) { // HOUR 증가: 0, 3, 6, 9, ..., 21 (total 3592)
                log.info("Generating URL for c_date: " + c_date + ", q: " + q + ", i: " + i);

                String apiurl = String.format(
                        "https://apis.data.go.kr/1360000/TourStnInfoService1/getTourStnVilageFcst1?ServiceKey=Dxhv%%2FFADXXMPmKxLHMxOkoyMrWL45dwTybbI8frUxCT1eyJKz0WstFSGR5f0XppdMp51F%%2FkluvX3%%2Bm4oTgJHJQ%%3D%%3D&pageNo=1&numOfRows=5&dataType=JSON&CURRENT_DATE=%d&HOUR=%d&COURSE_ID=%d",
                        c_date, q, i
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
                                WeatherEntity weather = new WeatherEntity();

                                String stringweather = item.getString("tm");
                                if (stringweather.length() == 16) { // "yyyy-MM-dd HH:mm" 형식이면
                                    stringweather += ":00"; // 초를 추가
                                }

                                Timestamp recorded_at = Timestamp.valueOf(stringweather);
                                weather.setRecorded_at(recorded_at);
                                weather.setTemper(item.optInt("th3", 0));
                                weather.setWinds(item.optInt("ws", 0));
                                weather.setRhm(item.optInt("rhm", 0));
                                weather.setPop(item.optInt("pop", 0));
                                // sname이 이미 존재하는지 확인
                                String regionName = item.optString("spotName"); // 예시로 sname을 사용
                                RegionsEntity region = regionsRepository.findBySname(regionName); // regionsRepository에서 region 조회

                                if (region != null) {
                                    weather.setRegions(region); // WeatherEntity에 지역 설정
                                    log.info("저장중 ------------------------------------{}",i);
                                    weatherRepository.save(weather); // WeatherEntity 저장
                                } else {
                                    log.error("Region not found for: " + regionName);
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

}
