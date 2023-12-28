package com.mkautomation.steps;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIStepDefs {

    @When("verify place name")
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        /*given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));*/
        Response response = given().
                when().
                get("http://zippopotam.us/us/90210");
        System.out.println(response.getBody().asString());
        response.then().
                assertThat().
                body("places[0].'place name'", equalTo("Beverly Hills"));

    }
}
