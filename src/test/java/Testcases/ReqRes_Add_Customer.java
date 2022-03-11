package Testcases;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ReqRes_Add_Customer extends TestBase {

    @Test
    void Create_Customer() {

        RestAssured.baseURI = "https://reqres.in";

        // Request Object
        httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "Aayush");
        requestParams.put("job", "QA");

        // Add a header stating the Request body is a JSON
        httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString()); // Post the request and check the response
        response = httpRequest.request(Method.POST, "/api/users");

        System.out.println(requestParams);
        System.out.println("The status received: " + response.statusLine());

    }
}
