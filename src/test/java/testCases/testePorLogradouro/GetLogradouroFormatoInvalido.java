package testCases.testePorLogradouro;

import org.junit.jupiter.api.Test;
import testBases.TestarPorLogradouro;

import static io.restassured.RestAssured.given;

public class GetLogradouroFormatoInvalido extends TestarPorLogradouro {

    @Test
    public void logradouroInvalido(){
        given()
            .log().all()
        .when()
            .get(URL + "/ws/RS/Gravatai/La12~~98ika/" + tipoDaRequisicao)
        .then()
            .log().all();
    }

}