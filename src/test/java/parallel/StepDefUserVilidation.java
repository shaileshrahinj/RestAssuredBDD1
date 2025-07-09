package parallel;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.utils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefUserVilidation extends utils {

	ResponseSpecification responespec;
	Response response;
	RequestSpecification res;
	private World world;
	
	
	 public StepDefUserVilidation(World world) {
		 this.world=world;
	 }
	@Given("Users api")
	public void users_api() throws IOException {
		 world.res = given().request().baseUri(getproperties("baseUrl2")).header("x-api-key", "reqres-free-v1").log().all();
		 System.out.println(world.res);

	}

	
	
	
}