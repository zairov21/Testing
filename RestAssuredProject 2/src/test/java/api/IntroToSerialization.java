package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.RequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Config;

public class IntroToSerialization {

    public static void main(String[] args) throws JsonProcessingException {
        String token = Config.getProperty("cashwiseToken");
        String baseUrl =Config.getProperty("baseUri");


        RequestBody body = new RequestBody();
        body.setName_tag("Ir1T1");
        body.setDescription("Data company");
        Response response = RestAssured.given().auth().oauth2(token).contentType(ContentType.JSON).body(body).post(baseUrl+ "/api/myaccount/tags");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        ObjectMapper mapper = new ObjectMapper();

        CustomResponse customResponse = mapper.readValue(response.asString(), CustomResponse.class);
        System.out.println(customResponse.getId());


    }
}
