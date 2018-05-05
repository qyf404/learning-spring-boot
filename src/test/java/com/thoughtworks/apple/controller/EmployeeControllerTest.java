package com.thoughtworks.apple.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void should_get_employees() {
        String expected = "[" +
                "    {" +
                "      \"id\": 0," +
                "      \"name\": \"小明\"," +
                "      \"age\": 20," +
                "      \"gender\": \"男\"" +
                "    }," +
                "    {" +
                "      \"id\": 1," +
                "      \"name\": \"小红\"," +
                "      \"age\": 19," +
                "      \"gender\": \"女\"  " +
                "    }," +
                "    {" +
                "      \"id\": 2," +
                "      \"name\": \"小智\"," +
                "      \"age\": 15," +
                "      \"gender\": \"男\"" +
                "    }," +
                "    {" +
                "      \"id\": 3," +
                "      \"name\": \"小刚\"," +
                "      \"age\": 16," +
                "      \"gender\": \"男\"" +
                "    }," +
                "    {" +
                "      \"id\": 4," +
                "      \"name\": \"小霞\"," +
                "      \"age\": 15," +
                "      \"gender\": \"女\"" +
                "    }" +
                "  ]";

        this.webClient.get().uri("/employees").exchange()
                .expectStatus().isOk()
                .expectBody().json(expected);
    }

    @Test
    public void should_get_employee() {
        String expected = " {" +
                "      \"id\": 1," +
                "      \"name\": \"小红\"," +
                "      \"age\": 19," +
                "      \"gender\": \"女\"  " +
                "    }";

        this.webClient.get().uri("/employees/1").exchange()
                .expectStatus().isOk()
                .expectBody().json(expected);
    }

    @Test
    public void should_create_employee() {
        String requestBody = "{" +
                "      \"name\": \"小张\"," +
                "      \"age\": 30," +
                "      \"gender\": \"女\"  " +
                "    }";
        String expected = "{" +
                "      \"id\": 5," +
                "      \"name\": \"小张\"," +
                "      \"age\": 30," +
                "      \"gender\": \"女\"  " +
                "    }";

        this.webClient.post().uri("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestBody), String.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody().json(expected);
    }
}