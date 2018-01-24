package poe.test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import javax.json.Json;
import javax.json.JsonObject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import poe.jpa.User;

public class UserServiceTest {
    private static RequestSpecification request;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "poe-jsf";
        RestAssured.defaultParser = Parser.JSON;
        request = RestAssured.given();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddUser() {
        JsonObject requestParams = Json.createObjectBuilder().add("email", "bob@mail.com").add("password", "1234")
                .build();

        request.body(requestParams.toString());
        Response response = request.post("/users/add");

        // int statusCode = response.getStatusCode();
        // assertEquals(statusCode, "201");
        // String successCode = response.jsonPath().get("SuccessCode");
        // assertEquals( "Correct Success code was returned", successCode,
        // "OPERATION_SUCCESS");
        //
        // get("/users")

        User[] persons = given().when().get("/users").as(User[].class);

        assertEquals("bob@mail.com", persons[0].getEmail());

        // .then()
        // .body("id", equalTo(12))
        // .body("firstName", equalTo("Vinod"))
        // .body("lastName", equalTo("Kashyap"))
        // .body("designation", equalTo("CEO"));
        //
        //
        // assertEquals( "Correct Success code was returned", successCode,
        // "OPERATION_SUCCESS");
    }

}
