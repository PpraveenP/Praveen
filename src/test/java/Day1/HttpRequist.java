package Day1;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequist {
	 int id;
	@Test
	void getUsers()
	{
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	@Test(priority=1)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("name", "praveen");
		data.put("job","software tester");
		
		
		id=given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		//.then()
		//.statusCode(201)
		//.log().all();
	}
	@Test(priority=2,dependsOnMethods = {"createUser"})
	void updateUSer()
	{
		HashMap data=new HashMap();
		data.put("name","naveen");
		data.put("job","developer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users?page="+id)
		
		.then()
		.statusCode(201)
		.log().all();
		
	}
	@Test(priority=3,dependsOnMethods={"updateUSer"})
	void deleteUSer()
	{
		given()
		
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		.then()
		.statusCode(204);
	}

}
