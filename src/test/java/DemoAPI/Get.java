package DemoAPI;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Get {

    @Test(priority = 1)
    void getUsers(){
        // Send GET request and validate response
        when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200);
            // Add more assertions as needed, such as validating response body, headers, etc.
    }
}
