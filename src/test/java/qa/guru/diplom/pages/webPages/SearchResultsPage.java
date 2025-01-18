package qa.guru.diplom.pages.webPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import qa.guru.diplom.enums.EducationEnum;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {

    private final SelenideElement commonTitle = $("[data-qa=\"title\"]");
    private final ElementsCollection titlesVacancy = $$("[data-qa=\"serp-item__title-text\"]");
    private final SelenideElement educationNotRequired =
            $("[data-qa=\"checkbox-container\"] [value=\"not_required_or_not_specified\"]");
    private final SelenideElement educationSpecial =
            $("[data-qa=\"checkbox-container\"] [value=\"special_secondary\"]");
    private final SelenideElement educationHigher =
            $("[data-qa=\"checkbox-container\"] [value=\"higher\"]");
    private final SelenideElement selectedSalary = $("[name=\"salary\"][checked]");


    @Step("Проверка отображения поискового запроса в тайтле {text}")
    public SearchResultsPage checkCommonTitleContainText(String text) {
        commonTitle
                .shouldBe(visible)
                .shouldHave(text(text));
        return this;
    }

    @Step("Проверка, что в названиях всех вакансий есть поисковой запрос {text}")
    public SearchResultsPage checkAllVacancyTitlesContainText(String[] text) {
        for (SelenideElement element : titlesVacancy) {
            element.shouldHave(oneOfTexts(text));
        }
        return this;
    }

    @Step("Проверка, что в названии первой вакансии есть поисковой запрос {text}")
    public SearchResultsPage checkFirstVacancyTitleContainText(String text) {
        titlesVacancy.first().shouldHave(text(text));
        return this;
    }

    @Step("Проверка, что выделен выбранный в расширенном поиске тип учёности {education}")
    public SearchResultsPage checkCheckedEducationCheckbox(EducationEnum education) {
        educationHigher.scrollIntoView(false);
        switch (education) {
            case EDUCATION_NOT_REQUIRED -> educationNotRequired.shouldBe(checked);
            case EDUCATION_SPECIAL -> educationSpecial.shouldBe(checked);
            case EDUCATION_HIGHER -> educationHigher.shouldBe(checked);
        }
        return this;
    }

    @Step("Проверка, что выбрана указанная в расширенном поиске зарплата {salary}")
    public SearchResultsPage checkValueSelectedSalary(String salary) {
        Assertions.assertEquals(salary, selectedSalary.getValue());
        return this;
    }
}
