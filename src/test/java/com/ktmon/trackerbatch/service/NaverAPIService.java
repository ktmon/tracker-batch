package com.ktmon.trackerbatch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktmon.trackerbatch.common.Config;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class NaverAPIService {

    ObjectMapper objectMapper;
    RestTemplate restTemplate;

    public void retrieveGoodsList() throws Exception {


        final HttpHeaders headers = new HttpHeaders();

        headers.set("X-Naver-Client-Id", Config.client_id);
        headers.set("X-Naver-Client-Secret", Config.client_secret);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange("https://openapi.naver.com/v1/search/news.json?display=100&query=wti&sort=date", HttpMethod.GET, entity, Map.class);

        log.info("{}", objectMapper.writeValueAsString(response.getBody()));

    }
}
