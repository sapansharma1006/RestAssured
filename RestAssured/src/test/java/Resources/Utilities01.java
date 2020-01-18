package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utilities01 {

	
	
//public  String getHost(String host) throws IOException{
//		
//		File file = new File("/Users/sapansharma/Onedirect/RestAssured/src/test/java/Resources/Environment.properties");
//		FileInputStream fis = new FileInputStream(file);
//		prop.load(fis);
//		String myhost= prop.getProperty(host);
//		return myhost;
//			
//	}
//	
//	
	
	public JsonPath rawToJson(Response response){
		
		String r = response.asString();
		JsonPath jp= new JsonPath(r);
//		String s = jp.toString();
		return jp;
		
		
	}


}
