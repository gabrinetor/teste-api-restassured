package testBases;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestarPorCep {

    protected static RequestSpecification requisicaoSpec;
    protected static ResponseSpecification respostaSpec;

    protected static boolean cepValido;
    protected static boolean cepInvalido;

    protected static final String URL = "https://viacep.com.br";
    protected static final String caminhoCepValido = "/ws/91060900/";
    protected static final String caminhoCepInexistente = "/ws/11110000/";
    protected static final String caminhoCepInvalido = "/ws/91060900A/";
    protected static final String tipoDaRequisicao = "json";

    @BeforeAll
    public static void iniciar() {
        requisitaSpec();
        respostaSpec();
    }

    public static void requisitaSpec(){
        requisicaoSpec = new RequestSpecBuilder()
                .setBaseUri(URL)
                .setBasePath( (cepValido ? (caminhoCepValido) : (cepInvalido ? caminhoCepInvalido : caminhoCepInexistente)) + tipoDaRequisicao)
                .build();
    }

    public static void respostaSpec(){
        respostaSpec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

}
