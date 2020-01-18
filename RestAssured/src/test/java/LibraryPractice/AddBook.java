package LibraryPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.ReturnPayload;
import Resources.Utilities01;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class AddBook {
	
Utilities01 ut = new Utilities01();
	
	
	Properties prop = new Properties();
	
	@BeforeTest
	public  void getHost() throws IOException{
	
	
	
	File file = new File("/Users/sapansharma/Onedirect/RestAssured/src/test/java/Resources/Environment.properties");
	FileInputStream fis = new FileInputStream(file);
	prop.load(fis);
	
	}
	

	@Test
	public void addBook() throws IOException{
	
		RestAssured.baseURI=prop.getProperty("LibraryHost");
		
		Response response= given()
		.header("Content-Type","application/json").and().body(ReturnPayload.getAddBook())
		.when()
		.post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).and().extract().response();
		
//		body("Msg",equalTo("successfully added"));
		
		JsonPath res= ut.rawToJson(response);
//		JsonPath j= new JsonPath(res);
		String msg = res.get("ID");
		System.out.println(msg);
		
		
		
		
	}

}
