package Day2;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class CreateUserFromMultipleWay {
	String id;
	
	@Test (priority=0)
	void createUserUsingJsonObject()
	{
		JSONObject data1=new JSONObject();
		 
		data1.put("name", "vaveen");

		String data2[]= {"2010","127","intel","1 TB"};
		data1.put("data",data2);
		
		id=given()
		.contentType("application/json")
		.body(data1.toString())
		
		.when()
		.post("https://api.restful-api.dev/objects")
		.jsonPath().getString("id");
		
		
	}
	@Test(priority = 1)
	void getUser()
	{
		given()
		
		.when()
		.get("https://api.restful-api.dev/objects/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=3)
	void deleteUser()
	{
		given()
		.when()
		.delete("https://api.restful-api.dev/objects/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}

}
