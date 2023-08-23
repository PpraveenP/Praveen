package Day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathQuryParameter {

	//@Test ()
	void usingPathQueryParameter()
	{
		//https://reqres.in/api/users?page=2
	




		given()
		.pathParam("mypath","users") //path parameter
		.queryParam("page",2)
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	//@Test()
	void testCoockies()
	{
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.cookie("AEC","Ad49MVFp6a8wJHzppm8K9vSHv1BjCDtTdi1SUVrpeNy6WmLg1mvaOXkW0EY")
		.log().all();
	}
	//get cookies details
	//@Test ()
	void  getCokiesInf()
	{
		Response res=given()
		
		
		.when()
		.get("https://www.google.com/");
		String cookies_Value = res.cookie("AEC");
		System.out.println("cookies value is--->"+cookies_Value);
	}
	
	//get all cookies information 
	@Test()
	void getCookiesInf()
	{
		Response res=given()
		
				.when()
				.get("https://www.google.com/");
				Map<String, String>cookies_Values=res.getCookies();
				for(String k:cookies_Values.keySet())
				{
					String cookies_name = res.getCookie(k);
					System.out.println(k+"  value is==>  "+cookies_name);
				}
			
		
	}
}
