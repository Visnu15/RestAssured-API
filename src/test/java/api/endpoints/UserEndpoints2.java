package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	
	//to load the properties files directly from src resources
	public static ResourceBundle loadingURLs() {
		ResourceBundle urls = ResourceBundle.getBundle("Routes");
		return urls;
	}

	public static Response createUser(UserPOJO payload) {
		
		String post = loadingURLs().getString("post_url");
		
		Response create = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(post);
		
		return create;
	}
	
	public static Response getUser(String username) {
		
		String getuser = loadingURLs().getString("get_url");
		
		Response get = given()
		.pathParam("username", username)
		
		.when()
		.get(getuser);
		
		return get;
	}
	
	public static Response updateUser(UserPOJO payload, String username) {
		
		String updateuser = loadingURLs().getString("update_url");
		
		Response put = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		
		.when()
		.put(updateuser);
		
		return put;
	}
	
	public static Response deleteUser(String username) {
		
		String deleteuser = loadingURLs().getString("delete_url");
		
		Response delete = given()
//		.accept(ContentType.JSON)
		.pathParam("username", username)
		
		.when()
		.delete(deleteuser);
		
		return delete;
	}
}
