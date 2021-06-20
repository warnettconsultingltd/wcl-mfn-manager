package com.wcl.contract;

import com.wcl.mfnmanager.contract.ContractApplication;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = ContractApplication.class)
public class ContractHealthIntegrationTest {

    @Test
    public void when_health_actuator_invoked_then_status_should_be_up() {
        given().
        when().
            get("http://localhost:9103/actuator/health").
        then().
            assertThat().
                statusCode(200).
        and().
            contentType(ContentType.JSON).
        and().
            body("status", equalTo("UP"));

    }

}
