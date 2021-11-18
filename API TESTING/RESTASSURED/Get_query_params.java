package payload;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Get_query_params {

   

    @Test
    public void getRequestWithQueryParam() {
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }
}