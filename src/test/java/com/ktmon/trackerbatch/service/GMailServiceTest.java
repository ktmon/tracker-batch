package com.ktmon.trackerbatch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


public class GMailServiceTest extends BaseServiceTest {

    @Autowired
    GMailService gMailService;

    @Test
    public void should_return_ok_when_send_mail() {
        gMailService.send();
    }
}
