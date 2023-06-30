package RestAssured;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestResumenCuentas {
    String url = "https://parabank.parasoft.com/parabank/services_proxy/bank/customers/13433/accounts";
    @Test
    @Tag("regresion")
    public void test(){
        given().auth().basic("dolores","123456")
                .when().get(url)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();;
    }
}
