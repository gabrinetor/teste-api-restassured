package testCases.testePorLogradouro;

import org.junit.jupiter.api.Test;
import testBases.TestarPorLogradouro;

import static io.restassured.RestAssured.given;

public class GetLogradouroInexistente extends TestarPorLogradouro {

    @Test
    public void logradouroInexistente(){
        given()
            .log().all()
        .when()
            .get(URL + "/ws/RS/Gravatai/Laika/" + tipoDaRequisicao)
        .then()
            .log().all();
    }

}