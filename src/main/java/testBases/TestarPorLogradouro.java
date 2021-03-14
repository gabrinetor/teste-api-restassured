package testBases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestarPorLogradouro {

    protected static RequestSpecification requisicaoSpec;
    protected static ResponseSpecification respostaSpec;
    protected static final String URL = "https://viacep.com.br";
    protected static final String caminho = "/ws/RS/Gravatai/Barroso/";
    protected static final String tipoDaRequisicao = "json";

    @BeforeAll
    public static void iniciar() {
        requisitaSpec();
        respostaSpec();
    }

    public static void requisitaSpec(){
        requisicaoSpec = new RequestSpecBuilder()
                .setBaseUri(URL)
                .setBasePath(caminho + tipoDaRequisicao).build();
    }

    public static void respostaSpec(){
        respostaSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

}
