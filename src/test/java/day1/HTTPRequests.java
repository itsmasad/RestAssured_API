package day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class HTTPRequests {
    
	// Setting global variable
	int id;

    @Test(priority = 1)
    void getUsers() {
   
    	when()
		// Sending the get request
    	.get("https://reqres.in/api/users?page=2")
    		
    .then()
		// Validating the response code
    	.statusCode(200)
		// Validating the key & value from the body
    	.body("page", Matchers.equalTo(2))
		// Printing the response
    	.log().all();
    }

	@Test(priority = 2)
	void createUser(){

		// Creating the data by using HashMap
		HashMap data = new HashMap<>();
		data.put("name", "Asad");
		data.put("job", "SQA");

		// Creating a variable before given section
		id=given()
		// #Specifying the content type and the body
			.contentType("application/json")
			// Sending the data
			.body(data)

		.when()
		// Sending the post request
		.post("https://reqres.in/api/users")
		// getting the value of the key from the response
		.jsonPath().getInt("id");

		/*.then()
			// Validating the response code
			.statusCode(201)
			// Printing the response
			.log().all();  */
	}
	
	// this test will only be executed if the createUser test is pass
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser(){

		// Creating the data by using HashMap
		HashMap data = new HashMap<>();
		data.put("name", "Asad");
		data.put("job", "Senior SQA");

		// Creating a variable before given section
		given()
		// #Specifying the content type and the body
			.contentType("application/json")
			// Sending the data
			.body(data)

		.when()
		// Sending the post request
		.put("https://reqres.in/api/users/"+id)
		// getting the value of the key from the response
		

		.then()
			// Validating the response code
			.statusCode(200)
			// Printing the response
			.log().all();  
	}

	// this test will only be executed if the updateUser test is pass
	@Test(priority = 4,dependsOnMethods = {"updateUser"})
	void deleteUser(){

		given()

		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();
	}


}
