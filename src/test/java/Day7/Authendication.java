package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authendication {
	
	@Test(priority=1)
	void basicAuthendication()
	{
		given()
			.auth().basic("postman","password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
	
		.then()
			.body("authenticated",equalTo(true))
			.statusCode(200)
			.log().all();
	
	}
	
	@Test(priority=2)
	void digestAuthendication()
	{
		given()
		.auth().digest("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	@Test(priority=3)
	void preempivetAuthendication()
	{
		given()
		.auth().preemptive().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
		
	}
	
	@Test(priority=3)
	void testBearerTokenAuthendication()
	{
		String bearer="Bearer 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";
		
		given()
		.headers("Authorization","Bearer "+bearer)
		
		.when()
		.get("https://github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=4)
	void oAuth1Authendication()
	{
		given()
		.auth().oauth("consumerkey", "cosumersecrat", "access token", "access secrat")
		.when()
		.get("url")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	//@Test(priority=5)
	void oAuth2Authendication()
	{
		given()
		.auth().oauth2("ghp-_24pH0Icz1PKHC1qOtLwj57AuDYmtSz2fuYKP")
		.when()
		.get("https://github.com/user/repos")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	//@Test()
	void apiKeyAuthendication()
	{
		given()
		.queryParam("key","value")
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200);
	}
}
