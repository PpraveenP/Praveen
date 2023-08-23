package Day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class Pojo {
	
	String id;

	@Test(priority = 0)
	void createUserUsingPojo()
	{
		
	
	Pojo_Request data1=new Pojo_Request();
	data1.setName("manga");
	
	//String arr[]= {"2012","900","intel","2 TB" };
	//data1.setData(arr);
	
	
	id=given()
			.contentType("application/json")
			.body(data1)
	
	.when()
	.post("https://api.restful-api.dev/objects")
	.jsonPath().getString(id);
		
	}
	
	@Test(priority=1,dependsOnMethods = {"createUserUsingPojo"})
	void getUser()
	{
		given()
		
		.when()
		.get("https://api.restful-api.dev/objects/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=2,dependsOnMethods = {"getUser"})
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
