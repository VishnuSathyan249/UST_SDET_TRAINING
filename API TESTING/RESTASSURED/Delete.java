package payload;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Delete {


    @Test
    public void deleteRequest() {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/posts/1")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
    }
}