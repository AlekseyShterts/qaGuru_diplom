package qa.guru.diplom.tests.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.hh.ru/";
    }
}
