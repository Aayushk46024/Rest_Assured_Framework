package Testcases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.annotations.Test;

public class Reqres_Delete_Customer extends TestBase {

    @Test
    void Create_Customer() {

        RestAssured.baseURI = "https://reqres.in";

        // Request Object
        httpRequest = RestAssured.given();

        // Add a header stating the Request body is a JSON
        httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request

        response = httpRequest.request(Method.DELETE, "/api/users/2");

        System.out.println("The status received: " + response.statusLine());

    }
}
