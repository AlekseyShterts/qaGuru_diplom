package qa.guru.diplom.tests.web;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.guru.diplom.pages.webPages.*;

import static com.codeborne.selenide.Selenide.open;
import static qa.guru.diplom.helpers.Constants.searchRequestJava;

@Tags({
        @Tag("web"),
        @Tag("all")
})
@Owner("Штерц Алексей")
@Epic("Веб тесты")
@Feature("Главная страница")
@DisplayName("Тесты на проверку элементов главной страницы")
public class GeneralePageTests extends WebTestBase {

    private final GeneralPage generalPage = new GeneralPage();
    private final EmployerPage employerPage = new EmployerPage();
    private final AreaSwitcherPage areaSwitcherPage = new AreaSwitcherPage();
    private final ModalLoginPage modalLoginPage = new ModalLoginPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Проверка кнопок в хедере страницы")
    void checkMainHeaderBlockTest() {
        open("");
        generalPage
                .checkVisibleAreaSwitcher()
                .checkEmployerElement()
                .checkExpertResumeElement()
                .checkApplicantServicesElement();
    }

    @ParameterizedTest(name = "Смена города на {0}")
    @ValueSource(strings = {"Новосибирск", "Краснодар"})
    @DisplayName("Проверка смены города")
    void checkChangeCityTest(String city) {
        open("");
        generalPage
                .clickAreaSwitcher();
        areaSwitcherPage
                .checkVisibleAreaSwitcher()
                .selectCity(city)
                .checkNotExistAreaColumn();
        generalPage.checkAreaSwitcherContainCity(city);

    }

    @Test
    @DisplayName("Переход на страницу для работодателей")
    void checkMoveToEmployerPageByHeaderLinkTest() {
        open("");
        generalPage
                .clickEmployerElement();
        employerPage
                .checkVisibleEmployerTitle()
                .checkVisibleEmployerSubtitle()
                .checkVisiblePublishVacancyButton();
    }

    @Test
    @DisplayName("Проверка выполнения поискового запроса")
    void checkSearchResultsTest() {
        open("");
        generalPage
                .setSearchRequest(searchRequestJava);
        modalLoginPage
                .closeModalPage();
        searchResultsPage
                .checkCommonTitleContainText(searchRequestJava);
    }
}
