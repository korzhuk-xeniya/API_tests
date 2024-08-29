package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTests {
    private final static String URL = "https://reqres.in/";
    @Test
    public void case2_returnListOfUsersAndEmailEndedReqresIn(){
        Specifications.installSpecification(Specifications.requestSpecifications(URL),
                Specifications.responseSpecification200());
        List<UserData> users = given()
                .when()
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        Assertions.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));
    }
}
