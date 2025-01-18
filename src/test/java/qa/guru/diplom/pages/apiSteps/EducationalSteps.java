package qa.guru.diplom.pages.apiSteps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import qa.guru.diplom.models.BadArgumentEducationalModel;
import qa.guru.diplom.models.ValidEducationalModel;

import static io.restassured.RestAssured.given;
import static qa.guru.diplom.specification.APISpecification.*;

public class EducationalSteps {
    @Step("Поиск образовательного учереждения по валидному id: {idModel}")
    public ValidEducationalModel getEducationalItemById(String idModel) {
        return given(requestSpec)
                .when()
                .get("/educational_institutions?id=" + idModel)
                .then()
                .spec(response200Spec)
                .extract().as(ValidEducationalModel.class);
    }

    @Step("Поиск образовательного учереждения по валидному id: {idModel} и локали = {locale}")
    public ValidEducationalModel getEducationalItemByIdAndLocale(String idModel, String locale) {
        return given(requestSpec)
                .when()
                .get(String.format("/educational_institutions?id=%s&locale=%s", idModel, locale))
                .then()
                .spec(response200Spec)
                .extract().as(ValidEducationalModel.class);
    }

    @Step("Поиск образовательного учереждения по невалидному id: {idModel}")
    public BadArgumentEducationalModel requestEducationalWithBadId(String idModel) {
        return given(requestSpec)
                .when()
                .get("/educational_institutions?id=" + idModel)
                .then()
                .spec(response400Spec)
                .extract().as(BadArgumentEducationalModel.class);
    }

    @Step("{step}")
    public EducationalSteps comparisonFields(Object expected, Object actual, String step) {
        Assertions.assertEquals(expected, actual);
        return this;
    }
}
