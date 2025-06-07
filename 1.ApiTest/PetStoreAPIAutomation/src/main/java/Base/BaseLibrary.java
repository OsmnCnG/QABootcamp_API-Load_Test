package Base;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class BaseLibrary extends Data {

    @Step("{urlPath} GET isteği gönderilir")
    public Response RestAssureGet(String urlPath) {
        Response response = RestAssured.get(urlPath);

        System.out.println("Response:"+response.getBody().asString());
        return response;
    }

    @Step("{urlPath} POST isteği gönderilir")
    public Response RestAssurePost(String urlPath, Map<String, Object> headersPayload, Map<String, Object> bodyPayload) {
        Response response = RestAssured.given().body(bodyPayload)
                .headers(headersPayload)
                .when()
                .post(urlPath);
        System.out.println("Response:"+response.getBody().asString());
        return response;
    }

    @Step("{urlPath} PUT isteği gönderilir")
    public Response RestAssurePut(String urlPath, Map<String, Object> headersPayload, Map<String, Object> bodyPayload) {
        Response response = RestAssured.given().body(bodyPayload)
                .headers(headersPayload)
                .when()
                .put(urlPath);
        System.out.println("Response:"+response.getBody().asString());
        return response;
    }

    @Step("{urlPath} DELETE isteği gönderilir")
    public Response RestAssureDelete(String urlPath) {
        Response response = RestAssured.delete(urlPath);
        System.out.println("Response:"+response.getBody().asString());
        return response;
    }

    @Step("{urlPath} GET isteği gönderilir")
    public Response RestAssureLogin(String urlPath, Map<String, Object> queryParamsPayload) {
        Response response = RestAssured.given()
                .queryParams(queryParamsPayload)
                .when()
                .get(urlPath);
        System.out.println("Response:"+response.getBody().asString());
        return response;
    }

    @Step("Assert kontrolü")
    public void AssertEquals(String act, String exp){
        Assert.assertEquals(act,exp);
    }


}
