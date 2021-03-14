package testCases.testePorCep;

import org.junit.jupiter.api.Test;
import testBases.TestarPorCep;

import static io.restassured.RestAssured.given;

public class GetCepFormatoInvalido extends TestarPorCep {

    @Test
    public void cepFormatoInvalido(){

        given()
            .spec(requisicaoSpec)
        .when()
            .get()
        .then()
            .spec(respostaSpec);

    }

}