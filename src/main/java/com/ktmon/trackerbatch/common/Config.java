package com.ktmon.trackerbatch.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    public static String client_id;

    public static String client_secret;

    @Value("${naver.api.client_id}")
    public void setClient_id(String client_id) {
        Config.client_id = client_id;
    }

    @Value("${naver.api.client_secret}")
    public void setClient_secret(String client_secret) {
        Config.client_secret = client_secret;
    }
}
