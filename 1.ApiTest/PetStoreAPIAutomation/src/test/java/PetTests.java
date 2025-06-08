import Base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class PetTests extends BaseTest {

    @Test(description = "Get - /v2/pet - Pet Information", priority = 2,dependsOnMethods = "CreatePet")
    public void GetPetInformation(){

        RestAssureGet(URL+"/v2/pet/1236540038");
    }

    @Test(description = "Delete - /v2/pet - Delete Pet", priority = 4)
    public void DeletePet(){

        RestAssureDelete(URL+"/v2/pet/1236540038");
    }

    @Test(description = "Post - /v2/pet - Pet Create", priority = 1)
    public void CreatePet(){
        Map<String, Object> headersPayload = new HashMap<>();

        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String, Object> bodyPayload = new HashMap<>();

        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("id", 0);
        categoryMap.put("name", "dog");

        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add("testUrl");

        Map<String, Object> tagObjectMap = new HashMap<>();
        tagObjectMap.put("id", 0);
        tagObjectMap.put("name", "testTag");

        List<Map<String, Object>> tagsList = new ArrayList<>();
        tagsList.add(tagObjectMap);

        bodyPayload.put("id", 1236540038);
        bodyPayload.put("category", categoryMap);
        bodyPayload.put("name", "bubu");
        bodyPayload.put("photoUrls", photoUrlsList);
        bodyPayload.put("tags", tagsList);
        bodyPayload.put("status", "test");

        RestAssurePost(URL+"/v2/pet",headersPayload,bodyPayload);
    }

    @Test(description = "Put - /v2/pet - Pet Update", priority = 3)
    public void UpdatePet(){
        Map<String, Object> headersPayload = new HashMap<>();

        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String, Object> bodyPayload = new HashMap<>();

        Map<String, Object> categoryMap = new HashMap<>();
        categoryMap.put("id", 2626);
        categoryMap.put("name", "Dog");

        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add("testUrl");

        Map<String, Object> tagObjectMap = new HashMap<>();
        tagObjectMap.put("id", 0);
        tagObjectMap.put("name", "testTag");

        List<Map<String, Object>> tagsList = new ArrayList<>();
        tagsList.add(tagObjectMap);

        bodyPayload.put("id", "1236540038");
        bodyPayload.put("category", categoryMap);
        bodyPayload.put("name", "bubu");
        bodyPayload.put("photoUrls", photoUrlsList);
        bodyPayload.put("tags", tagsList);
        bodyPayload.put("status", "test");

        RestAssurePut(URL+"/v2/pet",headersPayload,bodyPayload);
    }

    @Test(description = "Get - PetInformationControl",dependsOnMethods = "CreatePet")
    public void PetInformationControl(){

        Response response = RestAssureGet(URL+"/v2/pet/1236540038");

        AssertEquals(response.jsonPath().getString("id"),"1236540038");
        AssertEquals(response.jsonPath().getString("category.id"),"0");
        AssertEquals(response.jsonPath().getString("category.name"),"dog");
        AssertEquals(response.jsonPath().getString("name"),"bubu");
        AssertEquals(response.jsonPath().getString("photoUrls[0]"),"testUrl");
        AssertEquals(response.jsonPath().getString("tags[0].id"),"0");
        AssertEquals(response.jsonPath().getString("tags[0].name"),"testTag");
        AssertEquals(response.jsonPath().getString("status"),"test");

    }
}
