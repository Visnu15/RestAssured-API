package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.UserPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createUser(UserPOJO payload) {
		
		Response create = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routers.createUser);
		
		return create;
	}
	
	public static Response getUser(String username) {
		
		Response get = given()
		.pathParam("username", username)
		
		.when()
		.get(Routers.getUser);
		
		return get;
	}
	
	public static Response updateUser(UserPOJO payload, String username) {
		
		Response put = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", username)
		.body(payload)
		
		.when()
		.put(Routers.updateUser);
		
		return put;
	}
	
	public static Response deleteUser(String username) {
		
		Response delete = given()
//		.accept(ContentType.JSON)
		.pathParam("username", username)
		
		.when()
		.delete(Routers.deleteUser);
		
		return delete;
	}
}
