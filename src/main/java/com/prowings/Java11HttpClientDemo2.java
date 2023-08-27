package com.prowings;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Java11HttpClientDemo2 {

	
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		//Lets prepare the HttpRequest
		
		HttpRequest postReq = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/RestAPI-using-mvc/students"))
				.header("Content-type", "application/json")
				.POST(HttpRequest.BodyPublishers.ofString("{\n" +
				        "    \"id\": 16,\n" +
				        "    \"roll\": 16,\n" +
				        "    \"name\": \"Vaibhav\",\n" +
				        "    \"address\": \"Solapur\",\n" +
				        "    \"subjects\": [\n" +
				        "        {\n" +
				        "            \"id\": 19,\n" +
				        "            \"subName\": \"Music\",\n" +
				        "            \"author\": \"Shriram\"\n" +
				        "        },\n" +
				        "        {\n" +
				        "            \"id\": 16,\n" +
				        "            \"subName\": \"Geo\",\n" +
				        "            \"author\": \"Raj\"\n" +
				        "        }\n" +
				        "    ]\n" +
				        "}"))
				.build();
		
		HttpClient client = HttpClient.newBuilder()
				.build();
		
		HttpResponse<String> response = client.send(postReq, BodyHandlers.ofString());
		
		System.out.println(response.body());
		System.out.println(response.statusCode());
		System.out.println("git test");
	}

}