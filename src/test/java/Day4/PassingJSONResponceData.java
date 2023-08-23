package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PassingJSONResponceData {
	//@Test()
	void passingjsonRespData()
	{
		


		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		.header("Content-Type","application/json; charset=utf-8")
		.body("data[0].last_name",equalTo("Lawson"))
		.statusCode(200);
		
	}
//passing json response to validation
	
	
	//@Test()
	void passingJSonResp()
	{
		Response res=given()
				
		.when()
		.get("https://reqres.in/api/users?page=2");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		String last_name = res.jsonPath().get("data[0].last_name").toString();
		Assert.assertEquals(last_name,"Lawson");
		
	}
	
	//passing json response to validation using json object
	
	@Test()
	void passingRespUsingJsonObject()


	{
		Response res=given()
				.contentType(ContentType.JSON)
				
				.when()
				.get("https://reqres.in/api/users?page=2");
				
		JSONObject jo=new JSONObject(res.asString());
		
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		{
			String last_name= jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println(last_name);
			
		}
		//validating single name 
		
		boolean status=false;
		
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		{
			String lastname = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
		
			if(lastname.equals("Lawson"))
			{
				status=true;
				break;
			}
			
		}
		
		
		Assert.assertEquals(status,true);
		
		
		// Adding the id values 
		
		int idv=0;
		for(int i=0;i<jo.getJSONArray("data").length();i++)
		{
			String id = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
			idv=idv+Integer.parseInt(id);
		}
		System.out.println(idv);
	}
	
	
	
	
	
	
	
	
	
	
}
