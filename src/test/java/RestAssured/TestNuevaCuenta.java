package RestAssured;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestNuevaCuenta {
    String url = "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=13433&newAccountType=0&fromAccountId=15564";
    @Test
    @Tag("regresion")
    public void test(){
        given().auth().preemptive().basic("dolores","123456")
                .when().post(url)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }

}

