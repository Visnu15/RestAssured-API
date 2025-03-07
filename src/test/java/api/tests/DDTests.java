package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.UserPOJO;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	
	@Test(priority = 1, dataProvider = "allData", dataProviderClass = DataProviders.class)
	public void createUsers(String id, String un, String fname, String lname, String pass, String mail, String phone) {
		
		UserPOJO pojo = new UserPOJO();
		pojo.setId(Integer.parseInt(id));
		pojo.setUsername(un);
		pojo.setFirstname(fname);
		pojo.setLastname(lname);
		pojo.setEmail(mail);
		pojo.setPassword(pass);
		pojo.setPhone(phone);
		
		Response createUser = UserEndpoints.createUser(pojo);
		Assert.assertEquals(createUser.statusCode(), 200);
	}
	
	@Test(priority = 2, dataProvider = "allUserNames", dataProviderClass = DataProviders.class)
	public void deleteUsers(String un) {
		
		Response deleteUser = UserEndpoints.deleteUser(un);
		Assert.assertEquals(deleteUser.statusCode(), 200);
	}
}
