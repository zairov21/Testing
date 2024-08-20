package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntroToAPI {
    public static void main(String[] args) {
//        String baseUri = "https://backend.cashwise.us/";
//
////        RestAssured.given()
////                .auth()
////                .oauth2(token)
////                .baseUri(baseUri)
////                .when()
////                .get("/api/myaccount/sellers/all")
////                .then()
////                .statusCode(200);
////
////
////        RestAssured.given()
////                .auth()
////                .oauth2(token)
////                .baseUri(baseUri).queryParams("isArchived", false)
////                .queryParams("page", 1)
////                .queryParams("size", 2)
////                .when()
////                .get("/api/myaccount/sellers")
////                .then()
////                .statusCode(200);
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("isArchived", false);
//        params.put("page", 1);
//        params.put("size", 3);
//
//        Response response = RestAssured.given().auth().oauth2(token).params(params).get(baseUri+"api/myaccount/sellers");
//        System.out.println(response.statusCode());
//        System.out.println(response.prettyPrint());
//
//
//        String sellerId1 =response.jsonPath().get("responses.seller_i[0]").toString();
//        System.out.println(sellerId1);

        String baseUri = "https://backend.cashwise.us";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJleHAiOjE3MjU3NTMwODksImlhdCI6MTcyMzE2MTA4OSwidXNlcm5hbWUiOiJudXJlZWJlckBnbWFpbC5jb20ifQ.pCoUv9zNy39t3CoXlSeRVlwddQDhBHvZEMGrpmsHcKzCr2OevnXzpeTepcmFxrHouJPIMkebAAeYFZmlW9ihKA";

//            RestAssured.given()
//                .auth()
//                .oauth2(token)
//                .baseUri(baseUri)
//                .and()
//                .queryParam("isArchived", false)
//                .queryParam("page", 1)
//                .queryParam("size", 2)
//                .when()
//                .get("/api/myaccount/sellers")
//                .then()
//                .statusCode(200);

        Map<String, Object> params = new HashMap<>();
        params.put("isArchived", false);
        params.put("page", 1);
        params.put("size", 3);
        Response response = RestAssured.given().auth().oauth2(token).
                params(params).get(baseUri + "/api/myaccount/sellers");
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        String sellerId = response.jsonPath().get("responses.seller_id[0]").toString();
        System.out.println(sellerId);

        Response response1 = RestAssured.given().auth().oauth2(token).
                get(baseUri + "/api/myaccount/sellers/" + sellerId);
        System.out.println(response1.prettyPrint());

        String actualSellerId = response1.jsonPath().get("seller_id").toString();
        Assert.assertEquals(sellerId, actualSellerId);











    }
}
