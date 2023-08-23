package Day3;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {
	//@Test()
	void getHeader()
	{
		given()
		.when()
		.get("https://www.google.com/")
		
	.then()
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.and()
		.header("Content-Encoding","gzip")
		.and()
		.header("Server","gws");
	}
	
	//Getting all headers
	
	//@Test()
	void getHeaders()
	{
		Response res=given()
				
		.when()
		.get("https://www.google.com");
		
		Headers myHeaders = res.getHeaders();
		
		for(Header hd:myHeaders)
		{
			System.out.println(hd.getName()+"==>"+hd.getValue());
		}
	}
	
	//using logMethod to get header and all
	
	
	@Test()
	void usingLog()
	{
		given()
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.log().headers()
		.log().cookies()
		.log().body();
	}

}
