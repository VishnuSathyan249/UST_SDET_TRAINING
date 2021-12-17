package test;

import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SOD {
  public static final ObjectMapper MAPPER = new ObjectMapper();
	
	public static void main(String[] args) throws JsonProcessingException {
		SD_Example s1 = new SD_Example();
		s1.setId(8);
		s1.setName("Ninu");
		
		String url = "http://localhost:3000/posts";
		//String json = MAPPER.writeValueAsString(s1);
		
		
		Response response = RestAssured.given().
				contentType("application/json").log().all(true).
				body(s1).post(url).andReturn();
			
		
		assertEquals(response.getStatusCode(), 201,"http response");
				

	}

}
