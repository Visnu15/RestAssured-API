package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.UserPOJO;
import io.restassured.response.Response;

public class UserTests {

	UserPOJO pojo;
	Faker fake;
	
	public Logger log;
	
	//setting all the variables, i.e., payload to pass in request body
	@BeforeClass
	public void setup() {
		
		pojo = new UserPOJO();
		fake = new Faker();

		pojo.setId(fake.number().numberBetween(1000, 9999));
		pojo.setUsername(fake.name().username());
		pojo.setFirstname(fake.name().firstName());
		pojo.setLastname(fake.name().lastName());
		pojo.setEmail(fake.internet().emailAddress());
		pojo.setPassword(fake.internet().password(6, 10));
		pojo.setPhone(fake.phoneNumber().cellPhone());
		pojo.setUserStatus(0);
		
		log = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void createUser() {
		
		log.info("*************Creating User**************");
		Response createUser = UserEndpoints.createUser(pojo);
//		System.out.println(createUser.asPrettyString());
		Assert.assertEquals(createUser.statusCode(), 200);
		log.info("*************User Created****************");
		createUser.then().log().all();
//		String un = createUser.jsonPath().getString("username");
//		System.out.println(un);
	}
	
	@Test(priority = 2)
	public void getUser() {
		
		log.info("*************Getting User**************");
		Response user = UserEndpoints.getUser(this.pojo.getUsername());
//		System.out.println(user.asPrettyString());
//		System.out.println(user.jsonPath().getString("username"));
		Assert.assertEquals(user.statusCode(), 200);
		log.info("*************User Retrieved**************");
		user.then().log().all();
	}
	
	@Test(priority = 3)
	public void updateUser() {
		
		pojo.setFirstname(fake.name().firstName());
		pojo.setLastname(fake.name().lastName());
		
		log.info("*************Updating User**************");
		
		Response updateUser = UserEndpoints.updateUser(pojo, this.pojo.getUsername());
		updateUser.then().log().all();
//		System.out.println(updateUser.asPrettyString());
		Assert.assertEquals(updateUser.statusCode(), 200);
		
		log.info("*************User Updated**************");
		
		System.out.println("User Updated!");
		
		Response user = UserEndpoints.getUser(this.pojo.getUsername());
//		System.out.println(user.asPrettyString());
		user.then().log().all();
		Assert.assertEquals(user.statusCode(), 200);
	}
	
	@Test(priority = 4)
	public void deleteUser() {
		
		log.info("*************Deleting User**************");
		
		Response user = UserEndpoints.deleteUser(this.pojo.getUsername());
//		System.out.println(user.asPrettyString());
//		System.out.println(user.jsonPath().getString("username"));
		Assert.assertEquals(user.statusCode(), 200);
		
		log.info("*************User Deleted**************");
		
		user.then().log().all();
	}
}
