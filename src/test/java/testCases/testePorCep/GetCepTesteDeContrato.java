package testCases.testePorCep;

import Utilitarios.ArquivoDeOperacoes;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testBases.TestarPorCep;

import static io.restassured.RestAssured.given;

public class GetCepTesteDeContrato extends TestarPorCep {

    @Test
    public void criarContatoFazendoTesteDeContrato(){

        Response carga =
                given()
                    .spec(requisicaoSpec)
                    .log().all()
                .when()
                    .get()
                .then()
                    .log().all()
                    .spec(respostaSpec)
                    .extract()
                    .response();

        System.out.println("Estou feliz!");

        //FileOperations.setProperties("contact", "id", id);
        //id = payload.then().extract().path("data.id");

        String nomeDaResposta = carga.then().extract().path("cep");
        String nomeGuardado = ArquivoDeOperacoes.getProperties("logradouro").getProperty("cep");

        Assertions.assertEquals(nomeGuardado,nomeDaResposta);

       // deletaContato();

        carga.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Dados/Teste.json"));
    }

}
