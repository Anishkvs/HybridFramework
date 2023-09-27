package com.restapi;


public class Payload {
	
	public static String addPlace() {		
		
		return "{" +
	            "\"location\":{" +
	            "\"lat\" : -38.383494," +
	            "\"lng\" : 33.427362" +
	            "}," +
	            "\"accuracy\":50," +
	            "\"name\":\"Frontline house\"," +
	            "\"phone_number\":\"(+91) 983 893 3937\"," +
	            "\"address\" : \"29, side layout, cochin 09\"," +
	            "\"types\": [\"shop \",\"lulu\"]," +
	            "\"website\" : \"http://google.com\"," +
	            "\"language\" : \"English-IN\"" +
	            "}";
		
	}
	
	
	}
