package com.ktmon.trackerbatch.observers.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktmon.trackerbatch.common.Config;
import com.ktmon.trackerbatch.dto.KeywordParams;
import com.ktmon.trackerbatch.observers.Observer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Slf4j
@Component
@AllArgsConstructor
public class NaverAPIObserver implements Observer<KeywordParams> {

    ObjectMapper objectMapper;
    RestTemplate restTemplate;

    @Override
    public void update(KeywordParams naverNewsParams) {

        final HttpHeaders headers = new HttpHeaders();

        headers.set("X-Naver-Client-Id", Config.client_id);
        headers.set("X-Naver-Client-Secret", Config.client_secret);

        final HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate
                .exchange("https://openapi.naver.com/v1/search/news.json?" +
                        "display=" + naverNewsParams.getDisplay() +
                        "&query=" + naverNewsParams.getQuery() +
                        "&sort=" + naverNewsParams.getSort() +
                        "&start=" + naverNewsParams.getStart() + "", HttpMethod.GET, entity, Map.class);

        try {
            log.info("{}", objectMapper.writeValueAsString(response.getBody()));
        } catch (Exception e) {

        }

    }

}
