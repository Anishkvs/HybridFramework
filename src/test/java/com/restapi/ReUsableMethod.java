package com.restapi;

import io.restassured.path.json.JsonPath;

public class ReUsableMethod {
	
	
	public static JsonPath json(String response) {
		
	    JsonPath Js1 = new JsonPath(response);
	    return Js1;

		
	}
	
}






















/*
 * java.lang.IllegalStateException:
 * The path to the driver executable must be set by the webdriver.chrome.driver system property
 * Current Selenium v4.6.0
 */