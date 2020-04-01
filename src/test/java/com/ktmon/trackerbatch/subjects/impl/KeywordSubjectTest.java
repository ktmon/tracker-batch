package com.ktmon.trackerbatch.subjects.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktmon.trackerbatch.common.Config;
import com.ktmon.trackerbatch.dto.KeywordParams;
import com.ktmon.trackerbatch.observers.impl.NaverAPIObserver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest({KeywordSubject.class, NaverAPIObserver.class, RestTemplate.class, ObjectMapper.class, Config.class})
public class KeywordSubjectTest {

    @Autowired
    KeywordSubject keywordSubject;

    @Autowired
    NaverAPIObserver naverAPIObserver;

    @Test
    public void attach_and_collect() {
        KeywordParams keywordParams = KeywordParams.builder()
                .query("wti")
                .display(100)
                .sort("date")
                .start(1)
                .build();
        keywordSubject.attach(naverAPIObserver);
        keywordSubject.collect(keywordParams);
    }
}