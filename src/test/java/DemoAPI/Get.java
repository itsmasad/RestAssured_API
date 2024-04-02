package DemoAPI;

import static io.restassured.RestAssured.*;
import org.hamcrest.*;
import java.util.regex.Matcher;
import org.testng.annotations.Test;

public class Get {

    @Test(priority = 1)
    void getUsers(){
        // Send GET request and validate response
        when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page",Matchers.equalTo(2))
    }
}
