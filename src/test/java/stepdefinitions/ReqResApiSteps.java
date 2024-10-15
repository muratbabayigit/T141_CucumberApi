
package stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.jupiter.api.Assertions.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ReqResApiSteps {

    private Response response;
    private String baseUrl;

    // Step for GET request
    @Given("I have the ReqRes API endpoint for user with ID {int}")
    public void i_have_the_reqres_api_endpoint_for_user_with_id(Integer id) {
        baseUrl = "https://reqres.in/api/users/" + id;
    }

    @When("I send a GET request to the endpoint")
    public void i_send_a_get_request_to_the_endpoint() {
        response = RestAssured.get(baseUrl);
    }

    @Then("I should receive a status code {int}")
    public void i_should_receive_a_status_code(Integer statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the name should be {string}")
    public void the_name_should_be(String expectedName) {
        String name = response.jsonPath().getString("data.first_name");
        assertEquals(expectedName, name);
    }

    // Step for POST request
    @Given("I have the ReqRes API endpoint to create a user")
    public void i_have_the_reqres_api_endpoint_to_create_a_user() {
        baseUrl = "https://reqres.in/api/users";
    }

    @When("I send a POST request with user data")
    public void i_send_a_post_request_with_user_data() {
        String requestBody = "{ \"name\": \"John Doe\", \"job\": \"Leader\" }";
        response = RestAssured
                    .given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .post(baseUrl);
    }

    @Then("the name of the created user should be {string}")
    public void the_name_of_the_created_user_should_be(String expectedName) {
        String name = response.jsonPath().getString("name");
        assertEquals(expectedName, name);
    }
}
