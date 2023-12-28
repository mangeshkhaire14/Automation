package com.mkautomation.test.api;

import com.mkautomation.pojo.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

    private static final Logger log = LoggerFactory.getLogger(APITest.class);

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void getUsersPage() {

        Response response = given().when().get("/users?page=2");
       // given().queryParam("page",2);
        int statusCode = response.getStatusCode();
        log.info("Status Code:" + statusCode);

        Reporter.log("Status Code:" + statusCode);
        String responseBody = response.getBody().asString();
        log.info("Response Body:" + responseBody);
        Reporter.log("Response Body:" + responseBody);

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(response.path("total").toString(), "12");

    }

    @Test
    public void createUser() {

       /* String requestBody="{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";*/

        RequestSpecification request=RestAssured.given();
        //request.basePath("");
        request.contentType(ContentType.JSON);

        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","morpheus");
        jsonObject.put("job","leader");
        request.body(jsonObject.toJSONString());
        */
        User user=new User();
        user.setName("morpheus");
        user.setJob("leader");
        request.body(user);


        Response response = request.post("/users");
        int statusCode = response.getStatusCode();
        log.info("Status Code:" + statusCode);

        JsonPath jsonPath=new JsonPath(response.asString());

        Reporter.log("Status Code:" + statusCode);
        String responseBody = response.getBody().asString();
        log.info("Response Body:" + responseBody);
        Reporter.log("Response Body:" + responseBody);

        Assert.assertEquals(statusCode, 201);
        User userResponse=response.getBody().as(User.class);
        log.info("User Name:" + userResponse.getName());
        log.info("User Job:" + userResponse.getJob());

    }

}