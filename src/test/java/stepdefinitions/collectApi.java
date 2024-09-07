package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class collectApi {
        String endpoint;
        Response response;
    @Given("kullanici collectApi sitesine gider")
    public void kullanici_collect_api_sitesine_gider() {
        endpoint="https://api.collectapi.com";
    }
    @Then("kullanici path parametresi olarak {string} girer")
    public void kullanici_path_parametresi_olarak_girer(String pathParams) {
        endpoint=endpoint+"/"+pathParams;

    }
    @Then("kullanici query parametresi olarak {string} degerini {int} ve {string} degerini {string} olarak girer")
    public void kullanici_query_parametresi_olarak_degerini_ve_degerini_olarak_girer(String q1key, Integer q1value, String q2key, String q2value) {
        endpoint=endpoint+"?"+q1key+"="+q1value+"&"+q2key+"="+q2value;
    }
    @Then("kullanici donen response degerini kaydeder")
    public void kullanici_donen_response_degerini_kaydeder() {
        response=given().when().header("authorization"," apikey 5oSZHapxEMcTLinN9Gxa1Q:2U9cTgUL6ISgPLXXPQUPol").get(endpoint);

    }
    @Then("kullanici donen response degerini yazdirir")
    public void kullanici_donen_response_degerini_yazdirir() {
        response.prettyPrint();

    }
}
