package RestAssuredPractice.RestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class PracticePostCall {
	Properties prop = new Properties();
	
	@BeforeTest
	public void getHost() throws IOException{
		
		File file = new File("/Users/sapansharma/Onedirect/RestAssured/src/test/java/Resources/Environment.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
			
	}
	
	@Test
	public void postCall() throws FileNotFoundException{
		
		
		
		File file = new File("/Users/sapansharma/Onedirect/RestAssured/src/test/java/TestData/AddPlace.json");
		FileInputStream fis = new FileInputStream(file);
		
		
		String bodypath= file.getPath();
		
		RestAssured.baseURI=prop.getProperty("HOST");
		
		given().queryParam("key", "qaclick123").and().body(bodypath).
		when().post("/maps/api/place/add/json").
		then().statusCode(200).and().header("Server",equalTo("Apache"));
		
	}

}
