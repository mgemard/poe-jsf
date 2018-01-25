package poe.test;

import javax.json.Json;
import javax.json.JsonObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserServiceTest {
    private static RequestSpecification request;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/poe-jsf";
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
        System.out.println(RestAssured.baseURI + ":" + RestAssured.port + RestAssured.basePath + "/users");
        Response response = request.post("/users");

        // int statusCode = response.getStatusCode();
        // assertEquals(statusCode, "201");
        // String successCode = response.jsonPath().get("SuccessCode");
        // assertEquals( "Correct Success code was returned", successCode,
        // "OPERATION_SUCCESS");
        //
        // get("/users")

//        User[] persons = given().when().get("/users").as(User[].class);
//        List<String> emails = Arrays.stream(persons)
//                .map(person -> person.getEmail()).collect(Collectors.toList());
//        assertTrue(emails.contains("bob@mail.com"));
//        
//        
        
        get("/users").then().body("$.email", hasItem("bob@mail.com"));
        

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
