package Testcases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Add_Customer extends TestBase {

    @Test
    void Create_Customer() {
        RestAssured.baseURI = "https://api.stripe.com";
        // Basic Authentication
        PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
        authscheme.setUserName("sk_test_51KTR5NSGgQnAYv6SpVMMOxiW1dkNCmdV8A6Ju9vsqDab9ubTvb88N1RcrVDV8hQYg58MIqBI7LDRWa2tct1uTlyE00Fl3dwj6u");
        authscheme.setPassword("");
        RestAssured.authentication = authscheme;

        // Request Object
        httpRequest = RestAssured.given();


        // httpRequest.pathParam();
        httpRequest.formParam("email", "Saurav@gmail.com");
        httpRequest.formParam("name", "Saurav");

        response = httpRequest.request(Method.POST, "/v1/customers");
    }

    @Test
    void checkStatusCode() {
        logger.info("**************Checking Status Code************");
        //Status code Validation
        int statusCode = response.statusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }



}
