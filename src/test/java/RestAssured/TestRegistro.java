package RestAssured;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Tag;

import static io.restassured.RestAssured.*;


public class TestRegistro {

    @Test
    @Tag("smoke")
    public void testRegistroNuevoUsuario() {

        JSONObject request = new JSONObject();
        request.put("customer.firstName", "dolores");
        request.put("customer.lastName", "aleman");
        request.put("customer.address.street", "giovanii");
        request.put("customer.address.city", "Trento");
        request.put("customer.address.zipCode", "Tn1890");
        request.put("customer.phoneNumber", "1234567890");
        request.put("customer.ssn", "123456789");
        request.put("customer.username", "dolores6");
        request.put("customer.password", "123456");
        request.put("repeatedPassword", "123456");

        System.out.println(request.toJSONString());

        // Enviar la solicitud POST para registrar el nuevo usuario
        given()
                .header("content-type","application/json")
                .contentType(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .get("https://parabank.parasoft.com/parabank/register.htm")
                .then()
                .statusCode(200);
    }
}



