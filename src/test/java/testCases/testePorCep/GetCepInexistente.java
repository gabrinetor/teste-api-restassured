package testCases.testePorCep;

import org.junit.jupiter.api.Test;
import testBases.TestarPorCep;

import static io.restassured.RestAssured.given;

public class GetCepInexistente extends TestarPorCep {

    @Test
    public void cepInexistente(){

        given()
            .spec(requisicaoSpec)
        .when()
            .get()
        .then()
            .spec(respostaSpec);

    }

}