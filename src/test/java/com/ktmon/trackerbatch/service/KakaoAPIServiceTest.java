package com.ktmon.trackerbatch.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class KakaoAPIServiceTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void send_message_test() {


        ResponseEntity<Map> response = restTemplate.getForEntity("https://kapi.kakao.com/oauth/authorize?client_id=0a54b1d24c265df568611c9d21063a51&redirect_uri=/api/login&response_type=code", Map.class);
        log.info(response.toString());


    }
}
