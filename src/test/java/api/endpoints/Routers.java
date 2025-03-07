package api.endpoints;

public class Routers {

	//URLs
	public static String baseURL = "https://petstore.swagger.io/v2";
	
	//User Module
	public static String createUser = baseURL + "/user";
	public static String getUser = baseURL + "/user/{username}";
	public static String updateUser = baseURL + "/user/{username}";
	public static String deleteUser = baseURL + "/user/{username}";
}
