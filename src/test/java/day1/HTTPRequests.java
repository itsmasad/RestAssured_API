package day1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HTTPRequests {
    
    @Test
    void getUsers() {
   
    	when()
    	.get("https://reqres.in/api/users?page=2")
    		
    .then()
    	.statusCode(200)
    	.body("page", Matchers.equalTo(2))
    	.log().all();
    		
    
    }
}
