package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import parallel.World;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;



public class utils {
	
	//make it static so that it remain its state(should not reset to null) when parameterise is used
	static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException {
		
		
		
		//for logging.txt file should not replace exsisting logs
		if(req==null) {
		PrintStream log= new PrintStream(new FileOutputStream("loggin.txt"));
	    req = new RequestSpecBuilder().setBaseUri(getproperties("baseUrl2")).
	    		//addQueryParam("key", "qaclick123")
				addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
	    System.out.println(req);
		return req;
		}
		return req;
		
	}
	
	//to get properties from global.properties
	public static String getproperties(String key) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Shaz\\Work\\APIFramework2\\src\\test\\java\\resources\\globalProperties.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	//use this method when there is string, int key val pair
	public String getJsonPath(Response response, String key) {
		String resp=response.asString();
		JsonPath js =  new JsonPath(resp);
		return js.get(key).toString();
	}
	
	//use this method when there is string, string key val pair
	public String getJsonPathStr(Response response, String key) {
		
		String resp=response.asString();
		JsonPath js=  new JsonPath(resp);
		return js.get(key);
	}

}
