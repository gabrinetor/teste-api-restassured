package testCases.testePorLogradouro;

import org.junit.jupiter.api.Test;
import testBases.TestarPorLogradouro;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetLogradouroComparaConteudoCep extends TestarPorLogradouro {

    @Test
    public void logradouroComparaConteudoPorCep(){

        String cepDoLogradouro = "cep";
        String conteudoEsperado1 = "94085-170";
        String conteudoEsperado2 = "94175-000";

        given()
            .param("cep", cepDoLogradouro)
        .when()
            .get(URL + caminho + tipoDaRequisicao)
        .then()
            .body("cep[0]", equalTo(conteudoEsperado1))
        .and()
            .body("cep[1]", equalTo(conteudoEsperado2));

    }

}
