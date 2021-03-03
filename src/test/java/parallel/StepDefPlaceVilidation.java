package parallel;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlace;
import resources.APIResources;
import resources.TestDataBuid;
import resources.utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.io.PrintStream;
import java.util.Properties;

import groovy.util.logging.Log;

public class StepDefPlaceVilidation extends utils {

 RequestSpecification res; //making the variable global
	ResponseSpecification responespec;
	Response response;
	
	JsonPath js;
	static String place_id;
	TestDataBuid data= new TestDataBuid();
	private World world;
	static String firstname;
	
	 public StepDefPlaceVilidation(World world) {
		 this.world=world;
	 }
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String langauge, String address)  throws IOException {
		
			world.res=given().spec(requestSpecification()).
				body(data.addPlacePayload(name, langauge, address));

	}
	
	@Given("users info Payload with {string} {string}")
	public void users_info_Payload_with(String name, String job) throws IOException {
		
		//world.res= given().request().baseUri(getproperties("baseUrl2")).
		world.res=given().spec(requestSpecification()).
		body(data.createUserPayload(name, job)).log().all();
	}
	
	@Given("users update Payload with {string} {string}")
	public void users_update_Payload_with(String name, String job) throws IOException {
		
		//world.res= given().request().baseUri(getproperties("baseUrl2")).
		world.res=given().spec(requestSpecification()).
		body(data.createUserPayload(name, job)).log().all();
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		//getting the endpoints from enum
		//constructor will be called with value of resource which you pass.
		APIResources resourceApi = APIResources.valueOf(resource);
	System.out.println(resourceApi.getResource());	
	world.responespec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(method.equalsIgnoreCase("POST")) {
			world.response = world.res.when().post(resourceApi.getResource());	
		}
		else if (method.equalsIgnoreCase("GET")) {
			world.response = world.res.when().get(resourceApi.getResource());
		}
		else if (method.equalsIgnoreCase("DELETE")) {
			world.response = world.res.when().delete(resourceApi.getResource());
		}
		else if (method.equalsIgnoreCase("UPDATE")) {
			world.response = world.res.when().put(resourceApi.getResource());
		}
				
	}

	@Then("the API call is successfull with status code {int}")
	public void the_API_call_is_successfull_with_status_code(Integer int1) {
		assertEquals(world.response.getStatusCode(), 201);

	}
	
	@Then("for delete api the API call is successfull with status code {int}")
	public void for_delete_api_the_API_call_is_successfull_with_status_code(Integer int1) {
		assertEquals(world.response.getStatusCode(), 204);

	}
	
	@Then("for update api the API call is successfull with status code {int}")
	public void for_update_api_the_API_call_is_successfull_with_status_code(Integer int1) {
		assertEquals(world.response.getStatusCode(), 200);

	}

	@Then("{string} in response is {string}")
	public void in_response_is(String keyvalue, String expectedvalue) {
		
		
		assertEquals(getJsonPathStr(world.response, keyvalue), expectedvalue);
		System.out.println(expectedvalue);
	}
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws IOException {
	
		place_id=getJsonPath(world.response, "place_id");
		world.res=given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET");
		String actualname=getJsonPath(world.response, "name");
		System.out.println(actualname);
		assertEquals(expectedname, actualname);
	}
	
	@Given("deleteplace payload")
	public void deleteplace_payload() throws IOException {
	world.res =given().spec(requestSpecification()).body(data.deleteplacePayload(place_id));    
	}
	

	
	@When("user calls {string} with {string} http request and queryParam")
	public void user_calls_with_http_request_and_queryParam(String resource, String method) throws IOException {
	   world.res=given().request().baseUri(getproperties("baseUrl2")).queryParam("page",2).log().all();
	   user_calls_with_http_request(resource, "GET");
	   
	}
	
	@Then("verify first_name in reponse maps to {string} using {string}")
	public void verify_first_name_in_reponse_maps_to_using(String expectedname, String resource) throws IOException {
		 firstname= getJsonPathStr(world.response, "first_name");
		 System.out.println(firstname);
	   //world.res=given().request().baseUri(getproperties("baseUrl2"));
	   user_calls_with_http_request_and_queryParam(resource, "GET");
	  
	   String actualFirstName=getJsonPathStr(world.response, "data[0].first_name");
	   System.out.println(actualFirstName);
	   System.out.println(expectedname);
	   assertEquals(expectedname, actualFirstName);
		
	}
	/*@Then("{string} in resposnse body is {string}")
	public void in_resposnse_body_is(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
*/




}
