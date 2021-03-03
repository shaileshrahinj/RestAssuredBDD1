package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Location;
import pojo.addPlace;
import pojo.createUser;

public class TestDataBuid {
	
	public addPlace addPlacePayload(String name, String langauge, String address) {
	
	addPlace p=new addPlace();
	p.setAccuracy(50);
	p.setAddress(address);
	p.setLanguage(langauge);
	p.setPhone_number("(+91) 983 893 3937");
	p.setWebsite("http://google.com");
	p.setName(name);
	List<String> mylist=new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	p.setTypes(mylist);
	
	Location l=new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
	return p;
	}
	
	public String deleteplacePayload(String placeid ) {
		
		return "{\r\n   \"place_id\" : \""+placeid+"\"\r\n}";
	}
	
	public createUser createUserPayload(String name, String job) {
		createUser c= new createUser();
		c.setName(name);
		c.setJob(job);
		return c;
	}
	

}
