package resources;
//enum is a special class in java which has collection of costants and collection of methods
public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getplaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	singleuserAPI("/users/7"),
	usersInfoAPI("/users"),
	deleteUserAPI("/users/2"),
	UpdateUserAPI("/users/2");
	
	private String resource;
	
	APIResources(String resource){
		this.resource=resource;

	}
	
	public String getResource() {
		return resource;
	}
	

}
