package com.org.restapi.Restapi;

import org.mozilla.javascript.json.JsonParser;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;

import static com.jayway.restassured.RestAssured.*;

import javax.xml.ws.Response;
public class ReqGet {

	
	@Test(enabled=true)
    public void getName() {
                String country= given()
                .when()
                .get("https://istheapplestoredown.com/api/v1/status/worldwide")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .path("country.status");
                
                System.out.println("country: "+country);
    }

	@Test(enabled=true)
   public void validateResponse() {
               given().
               when().
               get("https://istheapplestoredown.com/api/v1/status/worldwide").
                then().
               assertThat().
                statusCode(200);
    }
	
	/*@Test(enabled=true)
	public void postc()
	{
		Response str=given()
				.body("{"
						+"\"name\": \"Indonesia\","
						+"\"status\": \"y,"
						+"}")
			.when()
			.post("https://istheapplestoredown.com/api/v1/status/worldwide");
			then()
			.statusCode(201);
			extract().response().jsonPath().getString("status");
		.extract().response().body().prettyPrint();
		JsonPath path = new JsonPath(str);
		String ID=path.getString("status");
		char[] name;
		System.out.println(name)*/
	JsonParser parser=new JsonParser(String cN, String y);
	String s = "{\"id\":{\"name\":\"Indonesia\",\"status\":\"y\"},\"at\":{\"name\":\"Indonesia\",\"status\":\"y\"}}";
	Object obj = parser.parseValue(s);
	ObjectMapper mapper = new ObjectMapper();
	System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj));
	 
	
	//POST
/*	@Test(enabled=true)
	public void postA(){
		
		GSt ll = new GSt();
		String str= given()
				
				.contentType(ContentType.JSON)
				.body(ll)
				.when()
				.post("https://istheapplestoredown.com/api/v1/status/worldwide");
		.then()
		.statusCode(201)
		.extract().response().body().prettyPrint();
		JsonPath path=new JsonPath(str);
		String ID =path.getString("id");
		System.out.println(ID);
		
		given()
		.pathParam("status", y)
		.when()
		.get("https://istheapplestoredown.com/api/v1/status/worldwide/[cname]")
		.then()
		.extract().response().body().prettyPrint();*/
	
	    }	
	}
	

