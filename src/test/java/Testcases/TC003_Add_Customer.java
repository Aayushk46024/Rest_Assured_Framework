package Testcases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.RestUtils;

public class TC003_Add_Customer extends TestBase {

    String custid;
    String name;

    @Test
    void Create_Customer() {

        custid = RestUtils.Custemailid();
        name = RestUtils.CustName();
        RestAssured.baseURI = "https://api.stripe.com";
        // Basic Authentication
        PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
        authscheme.setUserName("sk_test_QbRiu7Hnvf9JMlTO1TmLtcoT");
        authscheme.setPassword("");
        RestAssured.authentication = authscheme;

        // Request Object
        httpRequest = RestAssured.given();


        // httpRequest.pathParam();
        httpRequest.formParam("email", custid);

        httpRequest.formParam("name", name);
        response =  httpRequest.request(Method.POST, "/v1/customers");
        //Thread.sleep(3);
    }

    @Test
    void checkStatusCode() {
        logger.info("**************Checking Status Code************");
        //Status code Validation
        int statusCode = response.statusCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime() {
        logger.info("**************Checking Response Time************");
        long responseTime = response.getTime();

        Assert.assertTrue(responseTime < 2000);
    }

    @Test
    void checkStatusLine() {
        logger.info("**************Checking Status Line************");
        String statusline = response.statusLine();

        Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
    }

    @Test
    void checkContentType() {
        logger.info("**************Checking Content Type************");
        String contentType = response.header("Content-Type");

        Assert.assertEquals(contentType, "application/json");

    }

    @Test
    void checkServerType() {
        logger.info("**************Checking Server Type************");
        String serverType = response.header("Server");

        Assert.assertEquals(serverType, "nginx");

    }

    @Test
    void checkContentLength() {
        logger.info("**************Checking Content Length************");
        String contentLength = response.header("Content-Length");

        Assert.assertTrue(Integer.parseInt(contentLength) < 15000);
    }

    @AfterClass
    void teardown() {
        logger.info("**************Finished TC002_Get_Single_Customers*************");
    }
}
