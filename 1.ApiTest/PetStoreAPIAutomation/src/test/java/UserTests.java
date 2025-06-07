import Base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class UserTests extends BaseTest {

    @Test(description = "Get - /v2/user - User Information", priority = 2)
    public void GetUserInformation(){

        RestAssureGet(URL+"/v2/user/osmncn");
    }

    @Test(description = "Post - /v2/user - User Create", priority = 1)
    public void CreateUser(){
        Map<String, Object> headersPayload = new HashMap<>();

        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String, Object> bodyPayload = new HashMap<>();

        bodyPayload.put("id", "123123");
        bodyPayload.put("username", "osmncn");
        bodyPayload.put("firstName", "OsmanCan");
        bodyPayload.put("lastName", "GONEN");
        bodyPayload.put("email", "test");
        bodyPayload.put("password", "test");
        bodyPayload.put("phone", "test");
        bodyPayload.put("userStatus", "1");

        RestAssurePost(URL+"/v2/user",headersPayload,bodyPayload);
    }

    @Test(description = "Put - /v2/user - Update User",priority = 3)
    public void UpdateUser(){
        Map<String, Object> headersPayload = new HashMap<>();

        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String, Object> bodyPayload = new HashMap<>();

        bodyPayload.put("id", "123123");
        bodyPayload.put("username", "osmancan");
        bodyPayload.put("firstName", "OsmanCan");
        bodyPayload.put("lastName", "GONEN");
        bodyPayload.put("email", "test");
        bodyPayload.put("password", "test");
        bodyPayload.put("phone", "test");
        bodyPayload.put("userStatus", "1");

        RestAssurePut(URL+"/v2/user/osmncn",headersPayload,bodyPayload);
    }


    @Test(description = "Delete - /v2/user/ - Delete User",priority = 4)
    public void DeleteUser(){

        RestAssureDelete(URL+"/v2/user/osmancan");
    }

    @Test(description = "Get - /v2/user/login - Login")
    public void Login(){

        Map<String, Object> queryParamsPayload = new HashMap<>();

        queryParamsPayload.put("username","osmncn");
        queryParamsPayload.put("password","techcareer");

        RestAssureLogin(URL+"/v2/user/login", queryParamsPayload);
    }

    @Test(description = "Get - /v2/user/logout - Logout")
    public void Logout(){

        RestAssureGet(URL+"/v2/user/logout");
    }

    @Test(description = "Get - UserInformationControl")
    public void UserInformationControl(){
        Map<String, Object> headersPayload = new HashMap<>();

        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String, Object> bodyPayload = new HashMap<>();

        bodyPayload.put("id", "14752369");
        bodyPayload.put("username", "usercontrol");
        bodyPayload.put("firstName", "OsmanCan");
        bodyPayload.put("lastName", "GONEN");
        bodyPayload.put("email", "osmancangonen@hotmail.com");
        bodyPayload.put("password", "test");
        bodyPayload.put("phone", "123654");
        bodyPayload.put("userStatus", "1");

        RestAssurePost(URL+"/v2/user",headersPayload,bodyPayload);
        Response response = RestAssureGet(URL+"/v2/user/usercontrol");

        AssertEquals(response.jsonPath().getString("id"),"14752369");
        AssertEquals(response.jsonPath().getString("username"),"usercontrol");
        AssertEquals(response.jsonPath().getString("firstName"),"OsmanCan");
        AssertEquals(response.jsonPath().getString("lastName"),"GONEN");
        AssertEquals(response.jsonPath().getString("email"),"osmancangonen@hotmail.com");
        AssertEquals(response.jsonPath().getString("password"),"test");
        AssertEquals(response.jsonPath().getString("phone"),"123654");
        AssertEquals(response.jsonPath().getString("userStatus"),"1");

    }
}
