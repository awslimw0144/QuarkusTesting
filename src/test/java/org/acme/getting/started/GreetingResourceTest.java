package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testIndexEndpoint() {
        given()
                .when().get("/index")
                .then()
                .statusCode(200)
                .body(is("Hello. This is the main page. Send keys over to this page to go to greeting page"));
    }

    @Test
    public void testGreetingEndpoint() {
        String strUUID = UUID.randomUUID().toString();
        given().pathParam("name",strUUID)
                .when().get("/index/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("Hello " + strUUID));
    }


}