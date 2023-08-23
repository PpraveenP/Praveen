package Day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test()
	void updateUser(ITestContext context)
	{
		Faker fk=new Faker();
		JSONObject data=new JSONObject();
		
		data.put("name",fk.name().fullName());
		data.put("email",fk.internet().emailAddress());
		data.put("gender","female");
		data.put("status","active");
		
		String bearertoken="bb21790243185a980aaf092366280671a99c494d8d1271a6b4d3bcdd75828e04";
		int id=(Integer) context.getAttribute("user_id");
		
		given()
		.headers("Authendication","bearer "+bearertoken)
		.body(data.toString())
		.contentType("Application/json")
		.pathParam("id",id)
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();	
	}
}
