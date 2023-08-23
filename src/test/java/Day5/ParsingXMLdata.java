package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLdata {

		@Test()
		//Approach 1
		void ParsingXmlData()
		{
			given()
			
			.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
			
			.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("1") )
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		}
		
		
		//approach 2
		
		@Test()
		void ParsingXMLDataUsingResponse()
		{
			Response res=given()
					
					.when()
					.get("http://restapi.adequateshop.com/api/Traveler");
					
			Assert.assertEquals(res.getStatusCode(),200);
			Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
			
			String page = res.xmlPath().get("TravelerinformationResponse.page").toString();
			Assert.assertEquals(page,"1");
			
			String name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
			Assert.assertEquals(name,"Developer");
			
		}
		
		@Test()
		void testXMLResponse()
		{
			Response res=given()
					
					.when()
					.get("http://restapi.adequateshop.com/api/Traveler");
					
			XmlPath xmlobj=new XmlPath(res.asString());
			
			List<String>travelers=xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
			Assert.assertEquals(travelers.size(),10);
			
			//validating the travelers name 
			
			boolean status=false;
			List<String> traveler_names = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
			
			for(String traveler_name:traveler_names)
			{
				if(traveler_name.equals("vano"))
				{
					status=true;
					break;
				}
			}
			
		}
}
