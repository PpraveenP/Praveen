package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadDownload {

		@Test()
		void fileUpload()
		{
			File f=new File(".//body.file");

			given()
			.multiPart(f)  
			.when()
			.post("https://www.bytescale.com/dashboard/files")
			
			.then()
		
			.log().all();
		}
		
		//@Test()
		void fileDownload()
		{
			given()
			.when()
			.then()  ;
		}
}
