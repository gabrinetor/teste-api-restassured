package testCases.testePorLogradouro;

import org.junit.jupiter.api.Test;
import testBases.TestarPorLogradouro;

import static io.restassured.RestAssured.given;

public class GetLogradouroValido extends TestarPorLogradouro {

    @Test
    public void logradouroValido(){
    given()
        .log().all()
    .when()
        .get(URL + caminho + tipoDaRequisicao)
    .then()
        .log().all();
    }

}