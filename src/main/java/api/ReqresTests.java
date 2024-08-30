package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTests {
    private final static String URL = "https://reqres.in/";

    @Test
    public void testCase1_successRegisration(){
        Specifications.installSpecification(Specifications.requestSpecifications(URL),
                Specifications.responseSpecification200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        String email = "eve.holt@reqres.in";
        String password = "pistol";
        Register user = new Register(email, password);
        SuccessRegister successRegister = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessRegister.class);
        Assertions.assertNotNull(successRegister.getId());
        Assertions.assertNotNull(successRegister.getToken());
        Assertions.assertEquals(id,successRegister.getId());
        Assertions.assertEquals(token,successRegister.getToken());
    }
    @Test
    public void testCase1_regisrationWithoutPassword(){
        Specifications.installSpecification(Specifications.requestSpecifications(URL),
                Specifications.responseSpecification400());
        String email = "sydney@fife";
        String password = "";
        Register user = new Register(email, password);
        UnsuccessfulRegister unsuccessfulRegister = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessfulRegister.class);

        Assertions.assertEquals("Missing password", unsuccessfulRegister.getError() );
    }
    @Test
    public void testCase2_returnListOfUsersAndEmailEndedReqresIn(){
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
