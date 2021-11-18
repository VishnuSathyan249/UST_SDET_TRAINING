package com.restassured.api;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test02_Post {

	@Test
	public void test2() {

		JSONObject request = new JSONObject();
		request.put("id", "6");
		request.put("name", "Kiwi");

		//System.out.println(request);
		System.out.println(request.toString());
	    given().contentType(ContentType.JSON).
		body(request).
		when().
		post("http://localhost:8080/products").
		then().statusCode(201 );

	}

}