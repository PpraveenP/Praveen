package Day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test()
	void getUser(ITestContext context)
	{
		int id= (Integer) context.getAttribute("user_id");
		
		String bearertoken="bb21790243185a980aaf092366280671a99c494d8d1271a6b4d3bcdd75828e04";
			
		given()
			.headers("Authendiction","bearer "+bearertoken)
			.pathParam("id",id)
			
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}
