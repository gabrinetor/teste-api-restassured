package testCases.testePorCep;

import org.junit.jupiter.api.Test;
import testBases.TestarPorCep;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;

public class GetCepComparaConteudoLogradouro extends TestarPorCep {

    @Test
    public void cepComparaConteudoPorLogradouro(){

        String logradouroDoCep = "logradouro";
        String conteudoEsperado = "Avenida Assis Brasil 3940";

        given()
            .param("logradouro", logradouroDoCep)
        .when()
            .get(URL + caminhoCepValido + tipoDaRequisicao)
        .then()
            .body("logradouro", equalTo(conteudoEsperado));

    }
}
