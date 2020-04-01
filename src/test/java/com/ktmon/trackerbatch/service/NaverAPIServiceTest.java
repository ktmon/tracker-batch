package com.ktmon.trackerbatch.service;


import com.ktmon.trackerbatch.common.Config;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest({NaverAPIService.class, RestTemplate.class, Config.class})
public class NaverAPIServiceTest {

    @Autowired
    NaverAPIService naverAPIService;

    @Autowired
    Config config;

    @Test
    public void should_return_goods_list() throws Exception {
        naverAPIService.retrieveGoodsList();

    }
}
