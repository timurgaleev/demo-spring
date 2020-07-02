package com.example.aksisapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest

public class firsttest {
    @Autowired
    private GreetingController controller;

    @Test
    public void test() throws Exception {
        assertThat(controller).isNotNull();
    }


}
