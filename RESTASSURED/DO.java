package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DO {
   //public static final ObjectMapper MAPPER = new ObjectMapper();
   
	public static void main(String[] args) {
		String url ="http://localhost:3000/posts/5";
		SD_Example s2 = RestAssured.given().get(url).as(SD_Example.class);
		  //Response s2 = RestAssured.given().get(url);
		//System.out.println("post5="+s2.toString());
		System.out.println(s2);
	}

}
