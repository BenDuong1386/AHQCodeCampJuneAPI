package com.accesshq;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class APISuiteTest {

    @Test
    public void AusPostStatusTest() {
        given().relaxedHTTPSValidation().
            header("auth-key", "5a109321-22b0-41ce-8c37-0b6c5f685d7f").and().
            param("q", "Melbourne").and().
            param("state", "VIC").
        when().
            get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
            assertThat().statusCode(200);
    }

    @Test
    public void AusPostPostcodeTest() {
        given().relaxedHTTPSValidation().
            header("auth-key", "5a109321-22b0-41ce-8c37-0b6c5f685d7f").and().
            param("q", "Tascott").and().
            param("state", "NSW").
        when().
            get("https://digitalapi.auspost.com.au/postcode/search.json").
        then().
            assertThat().body("localities.locality.postcode", equalTo(2250));
    }
}
