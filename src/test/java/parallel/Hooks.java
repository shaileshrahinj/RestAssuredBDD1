package parallel;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	private World world;
	@Before("@deletePlaceAPI")
	public void beforeScenario() throws IOException{
		StepDefPlaceVilidation m = new StepDefPlaceVilidation(world);
		if(StepDefPlaceVilidation.place_id==null) {
		m.add_Place_Payload_with("shaz", "fregf", "Asio");
		m.user_calls_with_http_request("AddPlaceAPI", "post");
		m.verify_place_id_created_maps_to_using("shaz", "getplaceAPI");
		
	}

}
}
