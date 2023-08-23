package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;


import org.testng.annotations.Test;

public class JsonSchemaValidation {

	//@Test()
	void validateJsonSchema()
	{
		given()
		
		.when()
		.get("https://api.restful-api.dev/objects/7")	
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonTojsonSchema.json"));
		
	}
	@Test()
	void validatingXmltoXsd()
	{
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlTo.xsd"));

	}
}
