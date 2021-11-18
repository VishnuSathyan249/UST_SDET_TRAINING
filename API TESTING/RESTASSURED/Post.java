package payload;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Post {


    private static String requestBody = "{\n" +
            "  \"title\": \"foo\",\n" +
            "  \"body\": \"bar\",\n" +
            "  \"userId\": \"1\" \n}";

    @Test
    public void getRequest() {
    	 RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    	  Response response = given()
                  .header("Content-type", "application/json")
                  .and()
                  .body(requestBody)
                  .when()
                  .post("/posts").then().
                  extract().response();
    	  
    	  Assert.assertEquals(201, response.statusCode());
    	 Assert.assertEquals("foo", response.jsonPath().getString("title"));
    	  Assert.assertEquals("bar", response.jsonPath().getString("body"));
    	 Assert.assertEquals("1", response.jsonPath().getString("userId[0]"));
    	  Assert.assertEquals("101", response.jsonPath().getString("id"));
         System.out.println(response.body().asString());
    }
}