package qa.guru.diplom.tests.web;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import qa.guru.diplom.enums.EducationEnum;
import qa.guru.diplom.pages.webPages.ExtendedSearchPage;
import qa.guru.diplom.pages.webPages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;
import static qa.guru.diplom.enums.SearchByEnum.NAME_VACANCY;
import static qa.guru.diplom.helpers.Constants.*;

@Tags({
        @Tag("web"),
        @Tag("all")
})
@Owner("Штерц Алексей")
@Epic("Веб тесты")
@Feature("Страница расширенного поиска")
@DisplayName("Тесты на расширенный поиск")
public class ExtendedSearchTests extends WebTestBase {

    private final ExtendedSearchPage extendedSearchPage = new ExtendedSearchPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Проверка результатов расширенного поиска")
    void checkMainHeaderBlockTest() {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .specializationIsLoad()
                .setKeyWord(searchRequestJava)
                .clickFirstSuggestKeyWord()
                .setSearchByCheckbox(NAME_VACANCY)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkAllVacancyTitlesContainText(vacancyTagsJava);
    }

    @ParameterizedTest(name = "Проверка образования {0}")
    @EnumSource(EducationEnum.class)
    @DisplayName("Проверка применения настроек образования расширенного поиска")
    void checkApplyEducationSettingsExtendedSearchTest(EducationEnum education) {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .specializationIsLoad()
                .setKeyWord(searchRequestJava)
                .setEducationCheckbox(education)
                .removeAllRegions()
                .clickSubmit();
        searchResultsPage
                .checkFirstVacancyTitleContainText(searchRequestJava)
                .checkCheckedEducationCheckbox(education);
    }

    @Test
    @DisplayName("Проверка применения настроек зарплаты расширенного поиска")
    void checkApplySalarySettingsExtendedSearchTest() {
        open("/search/vacancy/advanced");
        extendedSearchPage
                .specializationIsLoad()
                .setKeyWord(searchRequestJava)
                .setSalary(salaryValue)
                .clickSubmit();
        searchResultsPage
                .checkValueSelectedSalary(salaryValue);
    }
}
