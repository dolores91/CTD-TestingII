package RestAssured;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestTransferirFondos {
    String url = "https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=15564&toAccountId=15564&amount=10";
    @Test
    @Tag("regresion")
    public void test(){
        given().auth().preemptive().basic("dolores","123456")
                .when().post(url)
                .then()
                .assertThat()
                .statusCode(200)
                .log().all();;
    }


}
