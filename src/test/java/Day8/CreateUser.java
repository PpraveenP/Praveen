package Day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@Test()
	void createuser(ITestContext context )
	{
	Faker fk=new Faker();
	
	
	
	JSONObject data=new JSONObject();
	//data.put("name", "Ms. jklggider");
	//data.put("gender", "male");
	//data.put("email", "ms_rigluukkhlla@pouros.example");
	//data.put("status", "inactive");
	System.out.println(data.put("name",fk.name().fullName()));
	System.out.println(data.put("gender","male"));
	System.out.println(data.put("email",fk.internet().emailAddress()));
	System.out.println(	data.put("status", "active"));
	
	String bearertoken="bb21790243185a980aaf092366280671a99c494d8d1271a6b4d3bcdd75828e04";
	
 int id=given()
		 	.headers("Authendiction","bearer "+bearertoken)
			.contentType("application.json")
			.body(data.toString())
			
			.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
			
   
  // context.setAttribute("user_id",id);
	

	}
}
