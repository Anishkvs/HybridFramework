package com.restapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;

public class RestApiFive {
	
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
		
		JsonPath js =ReUsableMethod.json(response);
		//JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println("Place Id:"+placeId);
		
// Update Place
		//Store the address 
		String newAddress = "Kakkanad, Kerala";
		
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\""+newAddress+"\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("maps/api/place/update/json")
		.then().assertThat().log().all().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
//Get Place
				
		String getResponse = given().queryParam("key", "qaclick123")
		.queryParam("place_id", placeId)
		.when().get("maps/api/place/get/json")
		.then().assertThat().log().all().statusCode(200)
		//Extract response as String
		.extract().response().asString();
		
		JsonPath Js1 = ReUsableMethod.json(getResponse);
	   // JsonPath Js1 = new JsonPath(getResponse);
		String actualAddress = Js1.getString("address");
		System.out.println(actualAddress);
		
		Assert.assertEquals(actualAddress, newAddress);
	}
	
}
