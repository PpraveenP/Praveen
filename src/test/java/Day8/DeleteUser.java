package Day8;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test()
	void deleteUser(ITestContext context)
	{
		
		String bearertoken="bb21790243185a980aaf092366280671a99c494d8d1271a6b4d3bcdd75828e04";
	 int id = (Integer)context.getAttribute("user_id");
		
		given()
		.headers("Authendication","bearer "+bearertoken)
		.pathParam("id",id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
