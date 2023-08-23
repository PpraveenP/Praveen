package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationDeserialization {
		
	//converting pojo object in to json

	@Test()
	void serialization() throws JsonProcessingException
	{
		Pojo obj=new Pojo();
		obj.setName("praveen");
		obj.setId(001);
		obj.setBranch("mechanical");
		
		//convert java object to json
		
		ObjectMapper objmaper=new ObjectMapper();
		
		String jsondata = objmaper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

		System.out.println(jsondata);
	}
	@Test()
	void deserialization() throws JsonMappingException, JsonProcessingException
	{
		String jsondata="{\r\n"
				+ "  \"name\" : \"praveen\",\r\n"
				+ "  \"id\" : 1,\r\n"
				+ "  \"branch\" : \"mechanical\"\r\n"
				+ "}";
		//converting json data in to pojo object
		
		ObjectMapper objmapper=new ObjectMapper();
		
		Pojo student = objmapper.readValue(jsondata,Pojo.class);
		
		System.out.println("branch is ==>"+student.getBranch());
		System.out.println("id is ==>"+student.getID());
		System.out.println("name is ==>"+student.getName());
		
		
	}
}
