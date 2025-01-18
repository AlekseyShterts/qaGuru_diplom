package qa.guru.diplom.tests.api;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.guru.diplom.pages.apiSteps.EducationalSteps;

import static qa.guru.diplom.helpers.TestData.*;

@Tags({
        @Tag("api"),
        @Tag("all")
})
@Owner("Штерц Алексей")
@Epic("Api автотесты")
@Feature("Ручки образовательных учреждений")
@DisplayName("Тесты на ручки образовательных учреждений")
public class EducationalInstitutionsTests extends ApiTestBase {

    @Test
    @DisplayName("Проверка запроса инфо об учебном заведении с валидным Id")
    void positiveEducationalRequestWithIdTest() {
        var testModel = getTestEducationalModelRu();
        var educationalSteps = new EducationalSteps();
        var response = educationalSteps
                .getEducationalItemById(testModel.getItems().get(0).getId());
        educationalSteps
                .comparisonFields(testModel, response, "Проверка ответа на валидность");
    }

    @ValueSource(strings = {";", "w", "ц", "test"})
    @ParameterizedTest(name = "Невалидный id '' {0} ''")
    @DisplayName("Проверка запроса инфо об учебном заведении с невалидным Id")
    void checkNegativeEducationalRequestTest(String badId) {
        var testModel = getBadArgumentTestEducationalModel();
        var educationalSteps = new EducationalSteps();
        var response = educationalSteps
                .requestEducationalWithBadId(badId);
        educationalSteps
                .comparisonFields(testModel.getErrors(), response.getErrors(), "Проверка корректности вернувшейся ошибки");
    }

    @Test
    @DisplayName("Проверка запроса инфо об учебном заведении с валидным параметрами Id и locale")
    void positiveEducationalRequestWithIdAndEnLocaleTest() {
        var testModel = getTestEducationalModelEn();
        var educationalSteps = new EducationalSteps();

        var response = educationalSteps
                .getEducationalItemByIdAndLocale(testModel.getItems().get(0).getId(), "EN");
        educationalSteps
                .comparisonFields(testModel, response, "Проверка ответа на валидность");
    }
}
