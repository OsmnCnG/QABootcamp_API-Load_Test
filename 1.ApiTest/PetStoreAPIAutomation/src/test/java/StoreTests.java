import Base.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class StoreTests extends BaseTest {

    @Test(description = "Get - /v2/store/inventory - Store Inventory")
    public void GetInventory(){
        RestAssureGet("https://petstore.swagger.io/v2/store/inventory");
    }

    @Test(description = "Get - /v2/store/order - Order Information",priority = 2)
    public void GetOrderInformation(){
        RestAssureGet(URL+"/v2/store/order/589589");
    }

    @Test(description = "Post - /v2/store/order - Order Create", priority = 1)
    public void CreateOrder(){
        Map<String, Object> headersPayload = new HashMap<>();

        headersPayload.put("accept","application/json");
        headersPayload.put("Content-Type","application/json");

        Map<String, Object> bodyPayload = new HashMap<>();

        bodyPayload.put("id", "589589");
        bodyPayload.put("petId", "589589");
        bodyPayload.put("quantity", "15");
        bodyPayload.put("shipDate", "2025-06-07T14:44:33.164Z");
        bodyPayload.put("status", "placed");
        bodyPayload.put("complete", "true");

        RestAssurePost(URL+"/v2/store/order",headersPayload,bodyPayload);
    }

    @Test(description = "Delete - /v2/store/order - Delete Order",priority = 3)
    public void DeleteOrder(){

        RestAssureDelete(URL+"/v2/store/order/589589");
    }


}
