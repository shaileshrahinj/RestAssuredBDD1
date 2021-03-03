package parallel;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuid;

public class World {
	RequestSpecification res; //making the variable global
	ResponseSpecification responespec;
	Response response;
	
	JsonPath js;
	static String place_id;
	TestDataBuid data= new TestDataBuid();

}
