package com.restapi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Z_ApiSecondStep {
	
	public static void main(String[] args) {
						
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
	//Copy the body content and paste into Payload class			
				.body(Payload.addPlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)")
				
	//Get the complete response into one String
	//Now we are getting only in Logs
	//Extract response in String Format
				.extract().response().asString();
		
		System.out.println(response);
		
		
	}
	
}

/* Copy the body content and paste into Payload class
 * 
 * Get the complete response into one String
 * Now we are getting only in Logs
 * Extract response in String Format
 */
