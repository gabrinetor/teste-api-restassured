package testCases.testePorLogradouro;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.TestarPorLogradouro;

import static io.restassured.RestAssured.given;

public class GerLogradouroBairro extends TestarPorLogradouro {

    @Test
    public void logradouroPorBairro(){

        Response payload =
                given()
                    .baseUri(URL)
                    .basePath(caminho + tipoDaRequisicao)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200).extract().response();

        String campoBairro = payload.then().extract().path("bairro[0]");
        String bairroAtual = "Morada do Vale I";

        Assertions.assertEquals(bairroAtual, campoBairro);

    }

}
