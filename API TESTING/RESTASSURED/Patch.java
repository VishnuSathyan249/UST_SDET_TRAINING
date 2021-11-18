package payload;



import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Patch {

    private static String requestBody = "{\n" +
            "  \"title\": \"bax\" \n}";

   

    @Test
    public void patchRequest() {
    	 RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("bax", response.jsonPath().getString("title"));
        Assert.assertEquals("1", response.jsonPath().getString("userId"));
        Assert.assertEquals("1", response.jsonPath().getString("id"));
    }
}