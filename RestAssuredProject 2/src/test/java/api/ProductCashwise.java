package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import entities.CustomResponse;
import entities.RequestBody;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.Config;

public class ProductCashwise {

    String token = Config.getProperty("cashwiseToken");
    String baseUri = Config.getProperty("baseUri");
    Faker faker = new Faker();
    int categoryId;
    RequestBody body = new RequestBody();


    @Given("user hits categories API endpoint to create one")
    public void user_hits_categories_api_endpoint_to_create_one() throws JsonProcessingException {

        body.setCategory_title(faker.name().title());
        body.setCategory_description(faker.name().firstName());
        body.setFlag(true);

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON)
                .body(body).post(baseUri+Config.getProperty("createCategoryCashEndpoint"));
        Assert.assertTrue(response.getStatusCode()==201);
        System.out.println(response.prettyPrint());

        ObjectMapper mapper = new ObjectMapper();

        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        this.categoryId = customResponse.getCategory_id();
    }
    @When("user hits API with baseUri and endpoint to create a product")
    public void user_hits_api_with_base_uri_and_endpoint_to_create_a_product() throws JsonProcessingException {
        body.setProduct_price(faker.random().nextInt(1, 1000));
        body.setService_type_id(1);
        body.setCategory_id(categoryId);
        body.setRemind_before_day(3);

        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(body)
                .post(baseUri+Config.getProperty("createProdCashEndpoint"));

        ObjectMapper mapper = new ObjectMapper();
        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);

        System.out.println(customResponse.getProduct_id() + customResponse.getProduct_price() + customResponse.getProduct_title());

    }

}
