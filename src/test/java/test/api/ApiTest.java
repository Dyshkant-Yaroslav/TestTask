package test.api;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.PropertiesReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    private PropertiesReader reader = new PropertiesReader();
    private Header standardHeader = new Header("Content-Type", "application/json");

    @BeforeMethod
    public void setup() {
        RestAssured.baseURI = reader.getBaseApiUrl();
    }

    @Test
    public void validateNameFromResponse() {
        given()
                .header(standardHeader)
                .when()
                .get(reader.getApiEndpoint())
                .then()
                .log().all()
                .statusCode(reader.getStatusCode200())
                .assertThat()
                .body(reader.getApiResponseBodyName(), equalTo(reader.getApiResponseExpectedName()));

    }

}
