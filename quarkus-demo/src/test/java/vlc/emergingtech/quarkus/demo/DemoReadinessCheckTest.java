package vlc.emergingtech.quarkus.demo;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.path.json.JsonPath;

@QuarkusTest
public class DemoReadinessCheckTest {

    @Test
    public void testHealthCheckEndpoint () {
        given()
          .when().get("/health")
          .then()
             .statusCode(200);
    }

    @Test
    public void testConfigHealthCheck () {
      JsonPath jsonPath = given()
        .when().get("/health")
        .thenReturn().jsonPath();
      assertEquals("UP", jsonPath.getString("status"));
      assertEquals(2, jsonPath.getList("checks").size());
    }

}