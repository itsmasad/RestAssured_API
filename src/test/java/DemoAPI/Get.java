package DemoAPI;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Get {

    @Test(priority = 1)
    void getUsers(){
        // Send GET request and validate response
        when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", Matchers.equalTo(2));
    }
}
