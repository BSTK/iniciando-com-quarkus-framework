package dev.bstk;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ValidadoresResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/validadores")
          .then()
             .statusCode(200)
             .body(is("Ok"));
    }

}