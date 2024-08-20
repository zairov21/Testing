package step_definitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CashWiseSteps {
    Response response;

    @Given("user provides params using token {string} and user hits baseUri {string} and api endpoint {string}")
    public void user_provides_params_using_token_and_user_hits_base_uri_and_api_endpoint(String token, String base, String api) {
        response = RestAssured.given().auth().oauth2(token).get(base + api);
        System.out.println(response = RestAssured.given().auth().oauth2(token).get(base + api));
    }
    @Then("user verifies status code is {int}")
    public void user_verifies_status_code_is(Integer statusCode) {

    }
    @Then("user verifies client_ids are not empty")
    public void user_verifies_client_ids_are_not_empty() {
    }
}
