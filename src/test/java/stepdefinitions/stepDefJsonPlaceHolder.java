package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import utilities.Configreader;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class stepDefJsonPlaceHolder {
    String endPoint;
    Response response;
    JSONObject postRequestBody;
    JsonPath resJP;

    @Given("kullanici base url olarak {string} adresine gider")
    public void kullanici_base_url_olarak_adresine_gider(String url) {
        endPoint= Configreader.getProperty(url);
    }
    @Then("kullanici pathParametresi olarak {string} girer")
    public void kullanici_path_parametresi_olarak_girer(String pathParams) {
        endPoint=endPoint+"/"+pathParams;

    }
    @Then("kullanici POST request icin {string},{string},{int} {int} ile reqBody olusturur")
    public void kullanici_post_request_icin_ile_req_body_olusturur(String title, String body, Integer userId, Integer id) {
        postRequestBody=new JSONObject();
        postRequestBody.put("title",title);
        postRequestBody.put("body",body);
        postRequestBody.put("userId",userId);
        postRequestBody.put("id",id);
    }
    @Then("kullanici reqBody bilgileri ile post request yapar ve response degerini kaydeder")
    public void kullanici_req_body_bilgileri_ile_post_request_yapar_ve_response_degerini_kaydeder() {
        response=given().contentType(ContentType.JSON).when().body(postRequestBody.toString()).put(endPoint);

    }
    @Then("kullanici response status degerinin {int} oldugunu test eder")
    public void kullanici_response_status_degerinin_oldugunu_test_eder(Integer statusCode) {
        assertEquals(response.getStatusCode(),statusCode);

    }
    @Then("kullanici content type degerinin {string} oldugunu test eder")
    public void kullanici_content_type_degerinin_oldugunu_test_eder(String contentType) {
        assertEquals(response.contentType(),contentType);

    }
    @Then("kullanici {string} header degerinin {string} oldugunu test eder")
    public void kullanici_header_degerinin_oldugunu_test_eder(String headerKey, String headerValue) {
        assertEquals(response.header(headerKey),headerValue);

    }
    @Then("kullanici response attribute degerlerinin {string}, {string}, {int} {int} oldugunu test eder")
    public void kullanici_response_attribute_degerlerinin_oldugunu_test_eder(String title, String body, Integer userId, Integer id) {
        resJP=response.jsonPath(); //gelen cevabı jSonPath formatına dönüştü
        assertEquals(resJP.getString("title"),title);
        assertEquals(resJP.getString("body"),body);
        assertEquals(resJP.getInt("userId"),userId);
        assertEquals(resJP.getInt("id"),id);
    }
}
