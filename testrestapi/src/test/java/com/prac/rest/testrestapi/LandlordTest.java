package com.prac.rest.testrestapi;
	import org.testng.annotations.Test;

	import com.jayway.restassured.http.ContentType;
	import com.jayway.restassured.path.json.JsonPath;

	import static com.jayway.restassured.RestAssured.given;
	import static org.hamcrest.Matchers.*;

public class LandlordTest {
		///GET method
		
	
	@Test(enabled=false)
		public void getLandlord() {
			String res = given()
			.pathParam("CountryCode", "IND")
			.when()
			.get("http://services.groupkt.com/state/get/{CountryCode}/all")
			.then()
			//.body("",is(empty()))
			.statusCode(200)
			.and()
			.body("RestResponse.result[10].country", is("IND"))
		    .body("RestResponse.result[10].country", isOneOf("IND"))
			.body("RestResponse.result[10].name", is("Odisha"))
			//.extract().response().body().prettyPrint();
			.extract().body().asString();
			System.out.println(res);

		}
		//POST method
		@Test(enabled=false)
		public void postLandlord() {
			Landlord landLord = new Landlord("Andrew1sucess234","Math",true);

			String str=given()
					//.contentType(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(landLord)
					/*.body("{"					
					+ "\"firstName\": \"Andrew1234\","
					+ "\"lastName\": \"Math\","
					+ "\"trusted\": 50,"
					+ "}")*/
					.when()
					.post("http://localhost:8080/landlords")
					.then()
					.statusCode(201)
					
					//.extract().response().jsonPath().getString("id");
					.extract().response().body().prettyPrint();
			JsonPath path = new JsonPath(str);
			String ID = path.getString("id");
			System.out.println(ID);

			given()
			.pathParam("id", ID)
			.when()
			.get("http://localhost:8080/landlords/{id}")
			.then()
			.extract().response().body().prettyPrint();

		}
		
		@Test(enabled=true)
		public void putLandlord(){
		Landlord landLord = new Landlord("AndrewIAMROBOT","Math4",true);
		String str=given()
				.contentType(ContentType.JSON)
				.body(landLord)
				.when()
				.post("http://localhost:8080/landlords")
				.then()
				.statusCode(201)
				//.extract().response().jsonPath().getString("id");
				.extract().response().body().prettyPrint();
		JsonPath path = new JsonPath(str);
		String ID = path.getString("id");
		System.out.println(ID);
	
		Landlord landLord1 = new Landlord("Andrew1234update","Mat23ffh",true);
				given()
				.contentType(ContentType.JSON)
				.pathParam("id","ID")
				.body(landLord1)
				.when()
				.put("http://localhost:8080/landlords{id}")
				.then()
				.statusCode(200)
				//.extract().response().jsonPath().getString("id");
				.extract().response().body().prettyPrint();
	
		}
}