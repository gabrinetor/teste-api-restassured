package testCases.testePorLogradouro;

import org.junit.jupiter.api.Test;
import testBases.TestarPorLogradouro;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class GetLogradouroVerQuantosCeps extends TestarPorLogradouro {

    @Test
    public void logradouroVerificarQuantosCeps() {

        given()
            .log().all()
        .when()
            .get("https://viacep.com.br/ws/RS/Gravatai/Barroso/json/")
        .then()
            .assertThat()
            .spec(respostaSpec)
        .and()
            .body("", hasSize(2));

    }

}
