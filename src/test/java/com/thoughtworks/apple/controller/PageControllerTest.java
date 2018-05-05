package com.thoughtworks.apple.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PageControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    public void should_get_home() {
        this.webClient.get().uri("/page/employees.html").exchange()
                .expectStatus().isOk();
    }
}
