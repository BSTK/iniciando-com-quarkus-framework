package dev.bstk;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AutoresResourceTest {

    @Test
    void deveRetornarTodosAutores() {
        given()
          .when().get("/autores")
          .then()
             .statusCode(200)
            .body(containsString("Jules Verne (1828-1905)"))
            .body(containsString("Aldous Huxley (1894-1963)"))
            .body(containsString("Arthur C. Clarke (1917-2008)"))
            .body(containsString("Isaac Asimov (1920-1992)"))
            .body(containsString("HG Wells (1866-1946)"))
            .body(containsString("George Orwell (1903-1950)"))
            .body(containsString("Geoffrey Hoyle (1941 – presente)"))
            .body(containsString("Philip K. Dick (1928-1982)"))
            .body(containsString("Douglas Adams (1952-2011)"));
    }

    @ParameterizedTest
    @CsvSource(
        delimiter = ';',
        value = {
        "0; Jules Verne (1828-1905)",
        "1; Aldous Huxley (1894-1963)",
        "2; Arthur C. Clarke (1917-2008)",
        "3; Isaac Asimov (1920-1992)",
        "4; HG Wells (1866-1946)",
        "5; George Orwell (1903-1950)",
        "6; Geoffrey Hoyle (1941 – presente)",
        "7; Philip K. Dick (1928-1982)",
        "8; Douglas Adams (1952-2011)"
    })
    void deveRetornarUmAutorDadoSeuIndice(final int index, final String autor) {
        given()
            .pathParam("index", index)
            .when()
            .get("/autores/{index}")
            .then()
            .statusCode(OK.getStatusCode())
            .body(is(autor));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, -2, -10, 100, 10, 90, 11})
    void deveRetornarErro400ParaRequestComIndiceInvalido(final int index) {
        given()
            .pathParam("index", index)
            .when()
            .get("/autores/{index}")
            .then()
            .statusCode(BAD_REQUEST.getStatusCode());
    }
}
