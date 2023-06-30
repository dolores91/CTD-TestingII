package RestAssured;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

public class TestActividadCuenta {

    String url = "https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13788/transactions/month/All/type/All";


    @Test
    @Tag("regresion")
    public void test() {
        given().auth().basic("dolores", "123456")
                .when().get(url)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();
    }
}
