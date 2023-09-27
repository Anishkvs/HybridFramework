package com.restapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Z_ApiThirdStep {
	
	public static void main(String[] args) {
						
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json")
				.body(Payload.addPlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
				.header("Server", "Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		
		System.out.println("Place Id: "+placeId);
	}
	
}

/* To copy the Place_id, We use JsonPath
 * Pass the JSON and extract the 'Place Id' from the body
 * 
 */
