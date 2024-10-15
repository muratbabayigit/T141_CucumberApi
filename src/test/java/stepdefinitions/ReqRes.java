
package stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ReqRes {

    private Response response;
    private String baseUrl;

    // GET isteği için adımlar
    @Given("ID'si {int} olan kullanıcı için ReqRes API uç noktasına sahibim")
    public void id_sahip_kullanici_icin_reqres_api_uct_noktasina_sahibim(Integer id) {
        baseUrl = "https://reqres.in/api/users/" + id;
    }

    @When("Uç noktaya bir GET isteği gönderirim")
    public void uc_noktaya_get_istegi_gonderirim() {
        response = RestAssured.get(baseUrl);
    }

    @Then("status kodunun {int} oldugu test edilir")
    public void status_kodunun_oldugu_test_edilir(Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("ismi {string} olmalı")
    public void ismi_olmali(String beklenenIsim) {
        String name = response.jsonPath().getString("data.first_name");
        assertEquals(beklenenIsim, name);
    }

    // POST isteği için adımlar
    @Given("Yeni bir kullanici olusturmak icin ReqRes adresine gidilir")
    public void yeni_bir_kullanici_olusturmak_icin_req_res_adresine_gidilir() {
        baseUrl = "https://reqres.in/api/users";
    }

    @When("Kullanıcı verileri ile bir POST isteği gönderilir")
    public void kullanici_verileri_ile_bir_post_isteği_gönderilir() {
        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"Leader\" }";
        response = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .post(baseUrl);
    }

    @Then("olusturulan kullanicin ismi {string} oldugu test edili")
    public void olusturulan_kullanicin_ismi_oldugu_test_edili(String beklenenIsim) {
        String name = response.jsonPath().getString("name");
        assertEquals(beklenenIsim, name);
    }
}
