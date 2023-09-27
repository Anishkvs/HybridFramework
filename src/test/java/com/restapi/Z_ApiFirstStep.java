package com.restapi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Z_ApiFirstStep {
	
	public static void main(String[] args) {
						
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body("{ \r\n"
						+ "  \"location\": { \r\n"
						+ "    \"lat\": -38.383494, \r\n"
						+ "    \"lng\": 33.427362 \r\n"
						+ "  }, \r\n"
						+ "  \"accuracy\": 50, \r\n"
						+ "  \"name\": \"Test APi\", \r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\", \r\n"
						+ "  \"address\": \"QA\", \r\n"
						+ "  \"types\": [ \r\n"
						+ "    \"shoe park\", \r\n"
						+ "    \"shop\" \r\n"
						+ "  ], \r\n"
						+ "  \"website\": \"http://google.com\", \r\n"
						+ "  \"language\": \"English-IN\" \r\n"
						+ "}")
				.when().post("maps/api/place/add/json")
				.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)");			
				
	}
		
}

/* Post
 * Initiate URL: 
 * Given ( Query-Param, Auth, Header, Body)
 * When - POST (Resource URL)
 * Then - Assert - StatusCode 
 * 
 * Add Body and Header for Then
 * 
 * 
 * 
 */