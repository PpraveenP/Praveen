package Day2;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class JsonFile {
	
	String id;
	
	@Test()
	 
	void createUser() throws FileNotFoundException
	{
		File f=new File(".//body.file");
		FileReader fr=new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
		
		id=given()
		.contentType("application/json")
		.body(data.toString())
				
		.when()
		.post("https://api.restful-api.dev/objects")
		.jsonPath().getString("id");
		
	}
	
	@Test(priority=1,dependsOnMethods = {"createUser"})
	void getSingleUser()
	{
		given()
		
		.when()
		.get("https://api.restful-api.dev/objects/"+id)
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=2,dependsOnMethods = {"getSingleUser"})
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
